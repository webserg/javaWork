__author__ = 'webserg'
import unittest

# class NinetyNineProblemsFixture(unittest.TestCase):
y = [1, 'two', 3, 4, 5, 6.0, 6.5, 7.0, 8]


def reverse(llist):
    return llist[::-1]


def isPolydrome(llist):
    return llist == llist[::-1]


print(reverse(y))
print(isPolydrome([1, 2, 1]))


# ?- my_flatten([a, [b, [c, d], e]], X).
# X = [a, b, c, d, e]

def flatten(nestedList):
    def aux(listOrItem):
        if isinstance(listOrItem, list):
            for elem in listOrItem:
                for item in aux(elem):
                    yield item
        else:
            yield listOrItem

    return list(aux(nestedList))


print(flatten(['a', ['b', ['c', 'd'], 'e']]))


class NinetyNineProblemsFixture(unittest.TestCase):
    def testFlatten(self):
        self.assertEqual(['a', 'b', 'c', 'd', 'e'], flatten(['a', ['b', ['c', 'd'], 'e']]))


if __name__ == '__main__':
    unittest.main()
