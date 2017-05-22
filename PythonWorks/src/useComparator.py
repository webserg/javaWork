key = ["a", "b", "c", "d", "e", "q", "g", "h", "a"]


def MyFn(f):
    return key


subjects = [1, 88, 3, 4, 5, 6, 6, 7, 8]
print(subjects)
subjects.sort(key=MyFn)
print(subjects)
var = [y for (x, y) in sorted(zip(key, subjects))]
print("sorted = ")
print(var)
print(subjects)
xy = zip(key, subjects)
srtxy = sorted(xy)
k, v = zip(*srtxy)
print(k)
for i in v:
    print(i)
tuples = ((1, "a"), (0, "w"))
print(sorted(tuples))
