import os

from decimal import Decimal

import sys
from iso8601 import iso8601

has_unique_sales = False
file_name = input()
sales_map = {}
unique_towns = {}

if os.path.isfile(file_name) and os.access(file_name, os.R_OK) and os.stat(file_name).st_size > 0:
    with open(file_name, encoding='utf-8') as f:
        for line in f.readlines():
            if line.strip():
                data = line.strip().split(',')
                if len(data) == 5:
                    item_id = data[0].replace('"', '')
                    country = data[1].replace('"', '')
                    town = data[2].replace('"', '')
                    date = iso8601.parse_date(data[3].replace('"', ''))
                    price = data[4].replace('"', '')


                    temp_set = set()

                    if item_id in sales_map:
                        temp_set = sales_map[item_id]
                        temp_set.add(town)
                        sales_map[item_id] = temp_set
                    else:
                        temp_set.add(town)
                        sales_map[item_id] = temp_set
                else:
                    print('INVALID INPUT')
                    sys.exit()

        for key, val in sales_map.items():
            if len(val) == 1:
                has_unique_sales = True
                town = ''.join(val)

                if town in unique_towns:
                    unique_towns[town].add(key)
                else:
                    temp_set = set()
                    temp_set.add(key)
                    unique_towns[town] = temp_set
        if len(unique_towns) > 0:
            for key, val in sorted(unique_towns.items()):
                print('{},{}'.format(key, ','.join(sorted(val))))
        else:
            print('NO UNIQUE SALES')
else:
    print('INVALID INPUT')
    sys.exit()
