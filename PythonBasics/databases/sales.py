import csv
import iso8601
import io
from decimal import Decimal
from datetime import datetime, timezone


class Sale:

    def __init__(self, item_id, country, city, sale_timestamp, price):
        self.item_id = str(item_id)
        self.country = str(country)
        self.city = str(city)

        if not isinstance(sale_timestamp, datetime):
            self.sale_timestamp = iso8601.parse_date(str(sale_timestamp))
        else:
            self.sale_timestamp = sale_timestamp

        # check if sale_timestamp is aware ...
        if self.sale_timestamp.tzinfo is None:
            raise ValueError("Naive datetimes not supported")
        else:
            self.sale_timestamp = self.sale_timestamp.astimezone(timezone.utc)

        if not isinstance(price, Decimal):
            self.price = Decimal(price)
        else:
            self.price = price

    def __repr__(self):
        return "Sale: " + str(self.__dict__)


def load_sales_data(filename_sales):
    with io.open(filename_sales) as f:
        sales = [
            Sale(
                item_id=sales_row[0],
                country=sales_row[1],
                city=sales_row[2],
                sale_timestamp=sales_row[3],
                price=sales_row[4],
            )
            for sales_row in csv.reader(f)
            ]
        return sales