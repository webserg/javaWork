def addFun(x, y):
    return x + y


# Call the function
addFun(2, 3)  # Output: 5

add = lambda x, y: x + y
res = add(2, 3)
print(res)


# print type(add)


def use_add(func):
    print(func(2, 3))


use_add(add)


def multiply2(x):
    return x * 2


l = [1, 2, 3, 4]
res2 = list(map(multiply2, l))
print(res2)

fibonacci = [0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55]
odd_numbers = list(filter(lambda x: x % 2, fibonacci))
print(odd_numbers)
