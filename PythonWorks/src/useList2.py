__author__ = 'webserg'
a_list = ["i", "am", "serg"]
print(a_list)
print(a_list[0])
print(a_list[a_list.__len__() - 1])
print(a_list.pop())
print(a_list)
a_list.pop(1)
print(a_list)
squares = [1, 4, 9, 16]
sum = 0
for num in squares:
    sum += num
print(sum)
lst = ['larry', 'curly', 'moe']
if 'curly' in lst:
    print('yey')
