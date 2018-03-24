__author__ = 'webserg'
import glob
import os

print(os.getcwd())
pathname = '/Users/pilgrim/diveintopython3/examples/humansize.py'
(dirname, filename) = os.path.split(pathname)
print(dirname)
print(glob.glob('*use*.py'))
print([os.path.realpath(f) for f in glob.glob('*use*.py')])
print([(os.stat(f).st_size, os.path.realpath(f)) for f in glob.glob('*.py')])
a_dict = {'a': 1, 'b': 2, 'c': 3}
print({value: key for key, value in a_dict.items()})
a_set = set(range(10))
print(a_set)
