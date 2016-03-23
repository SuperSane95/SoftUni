w = input()
h = input()
d = input()
file_name = input()

has_error = False

try:
    w = float(w)
    h = float(h)
    d = float(d)
except Exception as e:
    has_error = True

dimensions = sorted([w, h, d])

with open(file_name, encoding='utf-8') as f:
    for line in f.readlines():
        data = line.split(',')
        if len(data) > 0:
            med_name = data[0]
            med_w = float(data[1])
            med_h = float(data[2])
            med_d = float(data[3])
            temp_dimensions = sorted([med_w, med_h, med_d])

            # if any(dim < med_w for dim in dimensions)\
            #         or any(dim < med_h for dim in dimensions)\
            #         or any(dim < med_d for dim in dimensions):
            #     continue
            # else:
            #     print(med_name)

            if temp_dimensions[0] <= dimensions[0] and temp_dimensions[1] <= dimensions[1] and temp_dimensions[2] <= dimensions[2]:
                print(med_name)