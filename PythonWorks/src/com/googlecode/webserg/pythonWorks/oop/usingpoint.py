import sys
import Shape.Point
import math
a = Shape.Point.Point()
print(repr(a)) # returns: 'Point(0, 0)'
b = Shape.Point.Point(3, 4)
print(str(b)) # returns: '(3, 4)'
b.distance_from_origin() # returns: 5.0
b.x = -19
print(str(b)) # returns: '(-19, 4)'
a == b, a != b # returns: (False, True)
print('  __package__:', Shape.Point)
print('  __package__:', Shape.__path__)