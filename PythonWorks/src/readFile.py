__author__ = 'webserg'
import sys

try:
    f = open('c:\\devel\\csv.csv')
    s = f.readline()
    k = s.split(",")
    print(k)
    print([int(elem) * 2 for elem in k])
    i = int(k[0])
    print(i)
except OSError as err:
    print("OS error: {0}".format(err))
except ValueError:
    print("Could not convert data to an integer.")
except:
    print("Unexpected error:", sys.exc_info()[0])
    raise
