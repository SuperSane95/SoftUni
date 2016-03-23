import math

has_error = False
a = input()
b = input()
c = input()

try:
    a = float(a)
    b = float(b)
    c = float(c)
except Exception as e:
    has_error = True

if not has_error:
    p = (a + b + c) / 2
    s = math.sqrt(p * (p - a) * (p - b) * (p - c))
    print('{:.2f}'.format(s))
else:
    print('INVALID INPUT')