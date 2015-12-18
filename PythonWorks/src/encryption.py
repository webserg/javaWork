__author__ = 'webserg'

u = 'attack at dawn'
s = u.encode("iso-8859-1")
print(s[0])
print(ord(u[0]))
c = "09e1c5f70a65ac519458e7e53f36"
print('\x65')
print(''.join(format(x, '02x') for x in s))
u2 = "attack at dusk"
s2 = u2.encode("iso-8859-1")
print(''.join(format(x, '02x') for x in s2))
print(c)
print(bytes.fromhex('09e1c5f70a65ac519458e7e53f36').decode('iso-8859-1'))


def xor_strings(xs, ys):
    return "".join(chr(ord(x) ^ ord(y)) for x, y in zip(xs, ys))


def strxor(a, b):  # xor two strings of different lengths
    if len(a) > len(b):
        return "".join([chr(ord(x) ^ ord(y)) for (x, y) in zip(a[:len(b)], b)])
    else:
        return "".join([chr(ord(x) ^ ord(y)) for (x, y) in zip(a, b[:len(a)])])


def bxor(a, b):  # xor two strings of different lengths
    if len(a) > len(b):
        return "".join([chr(x ^ y) for (x, y) in zip(a[:len(b)], b)])
    else:
        return "".join([chr(x ^ y) for (x, y) in zip(a, b[:len(a)])])


k = strxor(u, bytes.fromhex('09e1c5f70a65ac519458e7e53f36').decode('iso-8859-1'))
m = strxor(u2, k)
print(''.join(format(x, '02x') for x in m.encode("iso-8859-1")))

# k = bxor(u.encode("iso-8859-1"), bytes.fromhex('6c73d5240a948c86981bc294814d'))
# m = bxor(u2, k)
# print(''.join(format(x, '02x') for x in m.encode("iso-8859-1")))