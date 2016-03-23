import math

w = float(input())
h = float(input())

paint = 1.76
wall = w * h

count = wall / paint

floating_part = count % 1

if floating_part > 0 :
    count += 1

count = int(count)

print(count)