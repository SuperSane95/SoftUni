prices = list()

price = input('Enter price: ')

while price != 'stop':
    prices.append(float(price))
    price = input('Enter price: ')

prices.sort()

if len(prices) == 1:
    print('Average: ' + str(prices[0]))

else:
    min_price = prices.pop(0)
    max_price = prices.pop(-1)

    while min_price in prices:
        prices.remove(min_price)

    while max_price in prices:
        prices.remove(max_price)

    if len(prices) == 0:
        print('No prices left after removing min and max element')
    else:
        print('Average: ' + str(sum(prices)/float(len(prices))))

