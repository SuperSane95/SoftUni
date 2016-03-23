import sqlite3

connection = sqlite3.connect('res/sales-example-imported.db', isolation_level=None)
print('Connection opened')
city_name = input('Enter city name: ')
cursor = connection.cursor()
cursor.execute('SELECT catalog_id, sale_timestamp, price FROM sale WHERE city_name = ? ORDER BY sale_timestamp', [city_name])
sales_by_town = cursor.fetchall()
catalog_id_to_item_key = {row[0]: row[1] for row in sales_by_town}

if len(sales_by_town) == 0:
    print('No sales are found in {}'.format(city_name))
else:
    print('Sales in {}'.format(city_name))
    for sale in sales_by_town:
        print('Артикул #: {}   дата/час: {}   сума: {}'.format(catalog_id_to_item_key[sale[0]], sale[1], sale[2]))
