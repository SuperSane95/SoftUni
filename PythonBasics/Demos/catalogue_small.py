price = 0
count = 0

with open('res/catalog_sample.csv') as cat:
    for line in cat:
        product = line.strip().split(',')
        try:
            price += float(product[-1])
            count += 1
        except ValueError:
            continue

if count is not 0:
    print('Average price is {}'.format(price / count))
else:
    print('File is empty')
