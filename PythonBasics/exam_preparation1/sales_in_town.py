item_id = input()
file_name = input()

item_map = {}

with open(file_name) as f:
    for line in f.readlines():
        data = line.split(',')
        temp_id = data[0]
        temp_id = temp_id.replace('"', '')
        temp_town = data[2]
        temp_price = float(data[-1])

        if temp_id not in item_map:
            item_map[temp_id] = [temp_town, temp_price]
        else:
            price = item_map[temp_id][1]
            if price > temp_price:
                item_map[temp_id] = [temp_town, temp_price]

print(item_map[item_id][0].replace('"', ''))
