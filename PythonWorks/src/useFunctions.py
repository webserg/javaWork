from utils import fun

print(fun(3))
import module1.f1
import module1.f2

print(module1.f1.fun1(1))
print(module1.f2.fun2(2))

from userInputFunctions import get_integer
from userInputFunctions import get_integer_by_text
age = get_integer() 
school_year = get_integer()
if age > 15:
    print("You are over the age of 15")
print("You are in grade " + str(school_year)) 
age = get_integer_by_text("enter int :") 