__author__ = 'webserg'
import fractions, math

x = fractions.Fraction(1, 3)
print(x * 2)
print(math.pi)
print(math.sin(math.pi / 2))


def is_it_true(anything):
    if anything:
        print("it is true", anything)
    else:
        print(anything, "it is false", anything)


is_it_true(1)
is_it_true(-1)
is_it_true(0)