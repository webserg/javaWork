'''Since all the items in a list are really object references, lists, like tuples, can
hold items of any data type, including collection types such as lists and tuples.
Lists can be compared using the standard comparison operators (<, <=, ==, !=, >=,
>), with the comparisons being applied item by item (and recursively for nested
items such as lists or tuples inside lists).
'''
L = [-17.5, "kilo", 49, "V", ["ram", 5, "echo"], 7]
print(L[-2])
print(L[1])
'''we can use the slice operator—repeatedly if necessary'''
L[0] == L[-6] == -17.5
L[1] == L[-5] == 'kilo'
L[1][0] == L[-5][0] == 'k'

L[4][2] == L[4][-1] == L[-2][2] == L[-2][-1] == 'echo'
L[4][2][1] == L[4][2][-3] == L[-2][-1][1] == L[-2][-1][-3] == 'c'
hair = ["black", "brown", "blonde", "red"]
hair2 = [hair[1:],"yellow"]
print(hair2)
for item in L:
	print(item)
'''changing lists'''
L2 = [1,2,3,4,5,6,7,8]
print(L2)	
def process(e):
	return e+1
for i in range(len(L2)):
	L2[i] = process(L2[i])
print(L2)
'''you can use any python expression in list'''
alist = [1, 9, 8, 4]
alist2 = [elem * 2 for elem in alist] 
'''A list comprehension creates a new list; it does not change the original list.'''
print(alist2)
alist3 = [elem for elem in alist  if elem % 2==0 ]
print(alist3)

alist = list(map(lambda x: x ** 2, [1, 2, 3, 4])) # returns: [1, 4, 9, 16]
print(alist)