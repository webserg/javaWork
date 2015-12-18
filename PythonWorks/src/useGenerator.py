__author__ = 'webserg'


def counterF(x):
    while True:
        yield x
        print("plus 1")
        x = x + 1


counter = counterF(0)
print(next(counter))
print(next(counter))
print(next(counter))
print(next(counter))
