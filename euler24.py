import itertools

perms = [''.join(p) for p in itertools.permutations('0123456789')]

print(perms[1000000-1])