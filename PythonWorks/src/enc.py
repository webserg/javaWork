__author__ = 'webserg'

MSGS = ("attack at dawn")


def strxor(a, b):  # xor two strings of different lengths
    if len(a) > len(b):
        return "".join([chr(ord(x) ^ ord(y)) for (x, y) in zip(a[:len(b)], b)])
    else:
        return "".join([chr(ord(x) ^ ord(y)) for (x, y) in zip(a, b[:len(a)])])


def random(size=16):
    return open("/dev/urandom").read(size)


def encrypt(key, msg):
    c = strxor(key, msg)
    print()
    print(c.encode('hex'))
    return c


if __name__ == "__main__":
    key = "09e1c5f70a65ac519458e7e53f36"
    print(key)
    ciphertexts = [encrypt(key, msg) for msg in MSGS]
    print(ciphertexts)
