__author__ = 'webserg'
x = "live and let \t \tlive"
x.split()
['live', 'and', 'let', 'live']
x.replace(" let \t \tlive", "enjoy life")
'live and enjoy life'
import re

regexpr = re.compile(r"[\t ]+")
regexpr.sub(" ", x)
print(x)
pi = 3.14
# text = 'The value of pi is ' + pi      ## NO, does not work
text = 'The value of pi is ' + str(pi)  # # yes
print(text)
a_string = 'My alphabet starts where your alphabet ends.'
print(a_string[3:6])
print(a_string)
string = "example"
for c in string:
    print("one letter: " + c)
