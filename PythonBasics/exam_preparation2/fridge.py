import csv

from iso8601 import iso8601

file_name = input()

with open(file_name) as f:
    data = csv.reader(f)
    last_temperature = None
    for line in data:
        last_temperature = float(line[1])
        break

    for line in data:
        temp_date = iso8601.parse_date(line[0])
        temp_temperature = float(line[1])
        temperature_delta = temp_temperature - last_temperature
        if temperature_delta >= 4.0:
            print(temp_date.isoformat())
        last_temperature = temp_temperature
