import unittest

from Stack import Stack


class KnownValues(unittest.TestCase):
    def __init__(self):
        s = Stack()
        print(s.isEmpty())
        s.push(4)
        s.push('dog')
        print(s.peek())
        s.push(True)
        print(s.size())
        print(s.isEmpty())
        s.push(8.4)
        print(s.pop())
        print(s.pop())
        self.assertEqual(self, 3, s.size(), "stack size wrong")


def main():
    KnownValues()


if __name__ == '__main__':
    main()
