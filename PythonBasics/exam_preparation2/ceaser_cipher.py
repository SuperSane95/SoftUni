import string

import sys

key = input()

try:
    key = int(key)
except ValueError as e:
    print("INVALID INPUT")
    sys.exit()

input_string = input()

alphabet = list(string.ascii_uppercase)
input_string = input_string.upper()
input_string = list(input_string)
output_string = []

for char in input_string:

    if char in alphabet:
        alphabet_index = alphabet.index(char)
        new_index = key + alphabet_index

        if new_index > 25:
            new_index = 0 + (new_index - 26)

        output_string.append(alphabet[new_index])
    else:
        output_string.append(char)


print(''.join(output_string))
