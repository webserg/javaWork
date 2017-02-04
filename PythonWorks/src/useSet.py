__author__ = 'webserg'
a_set = {1, 2, 3}
a_set.add(4, 5, 6)
a_set.add("yuyu")
print(a_set)
a_set = {2, 4, 5, 9, 12, 21, 30, 51, 76, 127, 195}
print(30 in a_set)
b_set = {1, 2, 3, 5, 6, 8, 9, 12, 15, 17, 18, 21}
print(a_set.union(b_set))
print(a_set.intersection(b_set))
