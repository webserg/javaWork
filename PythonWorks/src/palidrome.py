def isPolidrome(str):
    l = len(name)
    if (l % 2 != 0):
        return False
    mid = int(l / 2)
    i = 0
    while i < mid:
        if (str[i] != str[-i - 1]):
            print(str[i] + "!=" + str[-i - 1])
            return False
        print(str[i] + "==" + str[-i - 1])
        i = i + 1
    return True


name = input("enter string: ")
if (isPolidrome(name)):
    print("polidrome")
else:
    print("given string '" + name + "' not palidrome")
