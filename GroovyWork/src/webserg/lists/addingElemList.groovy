package webserg.lists

/**
 * Author: Sergiy Doroshenko
 * Date: Jan 25, 2010
 * Time: 12:20:39 AM
 */
myList = []
myList += 'a'
assert myList == ['a']
myList += ['b','c']
assert myList == ['a','b','c']
myList = []
myList << 'a' << 'b'     // left shift like append
assert myList == ['a','b']
assert myList - ['b'] == ['a']
assert myList * 2 == ['a','b','a','b']