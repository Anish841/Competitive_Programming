t = input()
mod = (10**9)+7
for tt in xrange(1,t+1):
    print "Case #"+str(tt)+":",
    n,k = map(int,raw_input().split())
    a1 = []
    a2 = []
    b1 = []
    b2 = []
    a1 = [int(i) for i in raw_input().split()]
    a2 = [int(i) for i in raw_input().split()]
    b1 = [int(i) for i in raw_input().split()]
    b2 = [int(i) for i in raw_input().split()]
    xa = []
    xb = []
    for i in xrange(n):
        for j in xrange(n):
            xa += [a1[i]^a2[j]]
    for i in xrange(n):
        for j in xrange(n):
            xb += [b1[i]^b2[j]]
    h1 = {}
    h2 = {}
    for i in xa:
        h1[i] = 0
    for i in xb:
        h2[i] = 0
    for i in xa:
        h1[i]+=1
    for i in xb:
        h2[i]+=1
    ans = 0
    for i in xa:
        x = i^k
        if x in h2:
            ans += h2[x]
    print ans
