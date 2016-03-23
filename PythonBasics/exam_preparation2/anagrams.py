file_name = input()
word = input()

anagrams = []

with open(file_name) as f:

    for line in f.readlines():
        temp_line = line.replace('\n', '')
        has_anagram = True
        char_list = sorted(list(word))
        file_char_list = sorted(list(temp_line))

        if len(char_list) == len(file_char_list):

            for i in range(len(char_list)):
                try:
                    if char_list[i] == file_char_list[i]:
                        has_anagram = True
                    else:
                        has_anagram = False
                        break
                except IndexError as e:
                    has_anagram = False
                    break

            if has_anagram and temp_line != word:
                anagrams.append(temp_line)


if len(anagrams) > 0:
    for word in sorted(anagrams):
        print(word)
else:
    print('NO ANAGRAMS')
