import os,fnmatch
from os.path import join, getsize
def countLines(root,name):
    count = 0
    if(fnmatch.fnmatchcase(name,'*.jsp')):
        print (name)
        for line in open(join(root, name),'r'):
            count += 1
    return count
LINES=0
FILES=0
for root, dirs, files in os.walk('c:\\projects\\HEAD\\standard\\siab'):
    #print(root, " consumes", end="")
    LINES += sum([countLines(root, name) for name in files])
    FILES += len(files)
    if 'CVS' in dirs:
        dirs.remove('CVS')  # don't visit CVS directories
print(LINES,"lines in ",FILES,"files")