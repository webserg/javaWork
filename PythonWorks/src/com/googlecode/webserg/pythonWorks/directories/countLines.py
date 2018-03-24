import glob
import os
from stat import *


def walktree(top, callback):
    for f in os.listdir(top):
        print (glob.glob('*.java'))
        pathname = os.path.join(top, f)
        mode = os.stat(pathname)[ST_MODE]
        if S_ISDIR(mode):
            # It's a directory, recurse into it
            walktree(pathname, callback)
        elif S_ISREG(mode):
            # It's a file, call the callback function
            callback(pathname)
        else:
            # Unknown file type, print a message
            print ('Skipping %s', pathname)


def visitfile(f):
    print(f)


def countLines(root, name):
    count = 0
    print (name)
    # for line in open(join(root, name),'r'):
    #    count += 1
    return count


if __name__ == '__main__':
    walktree('c:\\projects\\HEAD\\standard\\siab', visitfile)
    # os.walk('c:\\projects\\HEAD\\standard\\siab', visitfile, '')
