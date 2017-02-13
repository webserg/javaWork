teststring = "this is a test"
result = teststring.split("t")
print(result)
teststring = "  this      has a lot    of   spaces and    tabs"
result = teststring.split()
print(result)
listofstrings = ['a', 'b', 'c']
result = "**".join(listofstrings)
print(result)
inputStr = "My name is Michele"
reversedStr = inputStr.split()
reversedStr.reverse()
print(reversedStr)
resStr = ""
for s in reversedStr:
    resStr.join(s)
print(resStr)

print(inputStr.split()[::-1])
