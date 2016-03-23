price = 0
count = 0

with open('res/catalog_full.csv') as cat:
    for line in cat:
        product = line.strip().split(',')
        price += float(product[-1])
        count += 1

print('Average price is {}'.format(price/count))