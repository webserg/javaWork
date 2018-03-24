__author__ = 'webserg'
alist = list(map(lambda x: x ** 2, [1, 2, 3, 4]))  # returns: [1, 4, 9, 16]
print(alist)
x = ["first", "second", "third", "fourth"]
print(x[0])
mixture = [1, "two", 3, 4.0, ["a", "b"], (5, 6)]
print(mixture[4])
print(mixture[4][0])
print(mixture[5])
y = [1, 'two', 3, 4, 5, 6.0, 6.5, 7.0, 8]
print(y[3:])
y[2] = 'three'
print(y[2:5])


def useThis():
    return 1


def reverse(llist):
    return llist[::-1]


print(reverse(y))
print(reverse("abba"))
