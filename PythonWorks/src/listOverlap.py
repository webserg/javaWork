a = [1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89]
b = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13]
d=[]
for i in a:
    print(i)
    if i in b:
        d.append(i)
print(d)
print(a)
print(b)
shared = [item for item in a if item in b]
print(shared)