__author__ = 'webserg'
import os, glob

print(glob.glob("c:\\devel\\*.csv"))
print([f for f in glob.glob("c:\\devel\\*.csv") if os.stat(f).st_size > 20])