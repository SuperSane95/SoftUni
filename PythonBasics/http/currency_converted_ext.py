import requests
from decimal import Decimal
from datetime import datetime

input_currency = input('Enter input currency ')
output_currency = input('Enter output currency ')
value = Decimal(input('Enter value '))
back_date = input('Enter back date or leave blank if you want latest ')

connecting_message = 'Getting rates from network..'

try:
    if len(back_date) < 1:
        print(connecting_message)
        resp = requests.get('http://api.fixer.io/latest?',
                            params={'base': output_currency},
                            timeout=20)
    else:
        print(connecting_message)
        back_date = datetime.strptime(back_date, format('%Y-%m-%d'))
        resp = requests.get('http://api.fixer.io/{}?'.
                            format(back_date.strftime('%Y-%m-%d')),
                            params={'base': output_currency},
                            timeout=20)

    rates = resp.json()
except Exception as e:
    print('Something wrong happened --> ' + str(e))

modifier = rates['rates'][input_currency]
print('Result: {}'.format(value/Decimal(modifier)))
resp.close()