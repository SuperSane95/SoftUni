grouping = {
    'kid': [0.00, 0],
    'men': [0.00, 0],
    'women': [0.00, 0],
    'unisex': [0.00, 0],
    'infant': [0.00, 0]
}

with open('res/catalog_full.csv') as cat:
    for line in cat:
        product = line.strip().split(',')
        age = product[-2]

        try:
            price = float(product[-1])
        except ValueError:
            print('Couldn\'t parse price from line, going on next product.')
            continue

        if age == 'Kid' or age == 'kid':
            grouping['kid'][0] += price
            grouping['kid'][1] += 1
        elif age == 'Men' or age == 'men' or age == 'man' or age == 'Man':
            grouping['men'][0] += price
            grouping['men'][1] += 1
        elif age == 'Women' or age == 'women' or age == 'woman' or age == 'Woman':
            grouping['women'][0] += price
            grouping['women'][1] += 1
        elif age == 'Unisex' or age == 'unisex':
            grouping['unisex'][0] += price
            grouping['unisex'][1] += 1
        elif age == 'Infant' or age == 'infant':
            grouping['infant'][0] += price
            grouping['infant'][1] += 1
        else:
            print('Invalid age group')

for key, val in grouping.items():
    if val[1] != 0:
        print('Group {} have average price {}'.format(key, val[0] / val[1]))
    else:
        print('Group {} don\'t have products'.format(key))
