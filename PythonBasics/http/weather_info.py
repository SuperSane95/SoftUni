import requests
from datetime import datetime, timezone

city = input('Enter city: ')
appid = '965acdac1ae64cf06761bb563ad34d96'

try:
    resp = requests.get('http://api.openweathermap.org/data/2.5/weather?',
                        params={'q': city, 'appid': appid},
                        timeout=5)
    weather_data = resp.json()
except Exception as e:
    print('Something wrong happened --> ' + str(e))
finally:
    resp.close()

if weather_data['cod'] == 200:
    temperature = weather_data['main']['temp'] - 273.15
    pressure = weather_data['main']['pressure']
    humidity = weather_data['main']['humidity']
    wind = weather_data['wind']['speed']
    status = weather_data['weather'][0]['main']
    dt = datetime.fromtimestamp(weather_data['dt'], tz=timezone.utc)


    print('Current time: ' + str(dt))
    print('Status: {}'.format(status))
    print('Temperature: {:.2f}C'.format(temperature))
    print('Pressure: {}'.format(pressure))
    print('Humidity: {}%'.format(humidity))
    print('Wind: {}m/s'.format(wind))
else:
    print('{} is invalid'.format(city))



