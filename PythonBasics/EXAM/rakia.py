import os
import sys

import math

found_bidon = False
bidons = {}

try:
    rakia = float(input().strip())
    if rakia < 0:
        print('INVALID INPUT')
        sys.exit()
    rakia = rakia * 1000
    file_name = input().strip()
except Exception:
    print('INVALID INPUT')
    sys.exit()

if os.path.isfile(file_name) and os.access(file_name, os.R_OK) and os.stat(file_name).st_size > 0:
    try:
        with open(file_name, encoding='utf-8') as f:
            for line in f.readlines():
                if line.strip():
                    data = line.strip().split(',')
                    if len(data) == 3:
                        bidon_name = data[0].strip()
                        try:
                            radius = float(data[1].strip())
                            if radius < 0:
                                print('INVALID INPUT')
                                sys.exit()
                            vis = float(data[2].strip())
                            bidon_liters = math.pi * radius * radius * vis
                            if bidon_liters < 0:
                                print('INVALID INPUT')
                                sys.exit()
                            if bidon_liters >= rakia:
                                bidons[bidon_name] = bidon_liters
                        except Exception:
                            print('INVALID INPUT')
                            sys.exit()
                    else:
                        print('INVALID INPUT')
                        sys.exit()
    except Exception:
        print('INVALID INPUT')
        sys.exit()
else:
    print('INVALID INPUT')
    sys.exit()

if len(bidons) > 0:
    min = None
    best_bidon = None

    for key, val in sorted(bidons.items()):
        min = val
        best_bidon = key
        break

    for key,val in sorted(bidons.items()):
        if val < min:
            min = val
            best_bidon = key
    print(best_bidon)
else:
    print('NO SUITABLE CONTAINER')

