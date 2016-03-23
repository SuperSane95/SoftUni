import sys
import sqlite3
import logging

from datetime import datetime
from sales import load_sales_data
from catalog import load_catalog_by_item_id


def main():
    if len(sys.argv) < 4:
        print("Usage: {} <catalog-file.csv> <sales-file.csv> <output.db>".format(sys.argv[0]))
        return 2

    # TODO: check if files exist and are readable

    catalog_by_item_id = load_catalog_by_item_id(sys.argv[1])
    sales = load_sales_data(sys.argv[2])

    db_filename = sys.argv[3]

    with sqlite3.connect(db_filename, isolation_level=None) as connection:
        print("Connection opened")
        create_tables(connection)
        print("Tables created")
        import_catalog_into_db(catalog_by_item_id, connection)
        print("Catalog imported")
        import_sales_into_db(sales, connection)
        print("Sales imported")


def create_tables(connection):
    cursor = connection.cursor()
    cursor.execute("""
        create table if not exists sale (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            catalog_id INTEGER NOT NULL,
            country varchar(3),
            city_name varchar(60),
            sale_timestamp TEXT,
            price NUMERIC,
            FOREIGN KEY (catalog_id) REFERENCES catalog (id)
        );
    """)

    cursor.execute("""
        create table if not exists catalog (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            item_key varchar(200) UNIQUE,
            category varchar(200)
        );
    """)


def import_catalog_into_db(catalog_by_item_id, connection):
    cursor = connection.cursor()
    for catalog_entry in catalog_by_item_id.values():
        cursor.execute(
            "insert or replace into catalog (item_key, category) values (?, ?)",
            [catalog_entry.item_id, catalog_entry.category_name]
        )



def import_sales_into_db(sales, connection):
    cursor = connection.cursor()
    for sale in sales:
        cursor.execute('SELECT id FROM CATALOG where item_key = ?', [sale.item_id])
        result = cursor.fetchone()
        if result is None:
            with open('res/errors.txt', 'a') as f:
                f.write('{}: Unable to import {} because of invalid item id.\n'.format(datetime.utcnow(), str(sale)))
                logging.error('{}: Unable to import {} because of invalid item id.\n'.format(datetime.utcnow(), str(sale)))
        else:
            cursor.execute("""
            insert or replace into sale (catalog_id, country, city_name, sale_timestamp, price) values (?, ?, ?, ?, ?)
            """, [result[0], sale.country, sale.city, sale.sale_timestamp, float(sale.price)])


if __name__ == '__main__':
    main()
