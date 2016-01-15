def something(a):
    if a % 2 == 0:
        return a ** 2
    else:
        a -= 1
        return a


my_list = [1, 2, 3, 4, 5, 6]

for i in my_list:
    print(something(i))

