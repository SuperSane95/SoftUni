input_str = input()

symbol_map = {}

input_str = list(input_str)

if len(input_str) < 1:
    print('INVALID INPUT')
else:
    for char in input_str:
        if char in symbol_map:
            symbol_map[char] += 1
        else:
            symbol_map[char] = 1

most_seen_char = None
most_seen_char_value = symbol_map[input_str[0]]

for char, val in symbol_map.items():
    if val > most_seen_char_value:
        most_seen_char_value = val
        most_seen_char = char

print(most_seen_char)