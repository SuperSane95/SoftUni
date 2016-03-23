file_name = input()

hours = 0

with open(file_name, encoding='utf-8') as f:
    for line in f.readlines():
        try:
            data = line.split(',')
            distance = (int(data[1])+1) - int(data[0])
            max_speed = int(data[2])
            hours += distance/max_speed

        except Exception as e:
            print('INVALID INPUT')

print('{:.2f}'.format(hours))
