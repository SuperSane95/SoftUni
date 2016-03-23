import os

from datetime import datetime

import sys
from iso8601 import iso8601

file_name = input()
towns = set()
date_town_map = {}
all_data_avail = True

if os.path.isfile(file_name) and os.access(file_name, os.R_OK) and os.stat(file_name).st_size > 0:
    with open(file_name, encoding='utf-8') as f:
        for line in f.readlines():
            if line.strip():
                try:
                    data = line.split(',')
                    date = datetime.strptime(data[0], '%Y-%m-%d')
                    town = data[1].strip()
                    temp = data[2].strip()
                    towns.add(town)
                    temp_set = set()

                    if date in date_town_map:
                        temp_set = date_town_map[date]
                        temp_set.add(town)
                        date_town_map[date] = temp_set
                    else:
                        temp_set = set()
                        temp_set.add(town)
                        date_town_map[date] = temp_set
                except Exception:
                    print('INVALID INPUT')
                    sys.exit()

        for key, val in sorted(date_town_map.items(), key=lambda x: x[0]):
            missing_towns = set()
            for town in towns:
                if town not in val:
                    missing_towns.add(town)
                    all_data_avail = False
            if len(missing_towns) > 0:
                print('{},{}'.format(key.strftime('%Y-%m-%d'), ','.join(sorted(missing_towns))))

        if all_data_avail:
            print('ALL DATA AVAILABLE')
else:
    print('INVALID INPUT')
    sys.exit()