exchange_file = input()
amounts_file = input()

rates_dict = {}

with open(exchange_file, encoding='utf-8') as f:
    for line in f.readlines():
        file_string = line.split(' ')
        rates_dict[file_string[0]] = float(file_string[1])

bgn_amounts_dict = {}

with open(amounts_file, encoding='utf-8') as f:
    for line in f.readlines():
        file_string = line.split(' ')
        to_bgn_amount = float(file_string[0]) / rates_dict[file_string[1].strip()]
        print('{:.2f}'.format(to_bgn_amount))
