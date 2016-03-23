import requests
from decimal import Decimal

input_currency = input('Enter input currency ')
output_currency = input('Enter output currency ')

value = Decimal(input('Enter value '))

resp = requests.get('http://api.fixer.io/latest?base={}'.format(output_currency))
rates = resp.json()

modifier = rates['rates'][output_currency]
print('Result: {}'.format(value/Decimal(modifier)))
resp.close()