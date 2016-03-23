import os

import sys

file_name = input().strip()
x_coord = 0.0
y_coord = 0.0


if os.path.isfile(file_name) and os.access(file_name, os.R_OK) and os.stat(file_name).st_size > 0:
    with open(file_name, encoding='utf-8') as f:
        for line in f.readlines():
            try:
                if line.strip():
                    data = line.split(' ')
                    if len(data) == 2:
                        direction = data[0].strip()
                        distance = float(data[1].strip())

                        if direction == 'right':
                            x_coord += distance
                        elif direction == 'left':
                            x_coord -= distance
                        elif direction == 'up':
                            y_coord += distance
                        elif direction == 'down':
                            y_coord -= distance
                        else:
                            print('INVALID INPUT')
                            sys.exit()
                    else:
                        print('INVALID INPUT')
                        sys.exit()
            except Exception:
                print('INVALID INPUT')
                sys.exit()

        print('X {:.3f}'.format(x_coord))
        print('Y {:.3f}'.format(y_coord))
else:
    print('INVALID INPUT')
    sys.exit()

