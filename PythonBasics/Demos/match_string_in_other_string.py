text1 = input('Enter text: ')
text2 = input('Enter text: ')

index = text1.find(text2)

if index != -1:
    index += len(text2)
    print(text1[index:len(text1)])
else:
    print('Second text not found in first text.')
