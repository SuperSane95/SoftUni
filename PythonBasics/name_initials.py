name = None

while name is None or name is '' or name is ' ':
    name = input('Enter name: ')

names = name.split(' ')

for name in names:
    if name[0].isupper():
        print(name[0] + '.', end='')
