t = input()
mod = (10**9)+7
for tt in xrange(1,t+1):
    print "Case #"+str(tt)+":",
    n,x,k,a,b,c = map(int,raw_input().split())
    den = 100**n
    bfs = [(0,x,1)]
    for i in xrange(n):
        while(bfs[0][0]==i):
            X = bfs.pop(0)
            pr = X[-1]
            z = X[1]
            i1 = z&k
            bfs+=[(i+1,i1,pr*a)]
            i2 = z|k
            bfs+=[(i+1,i2,pr*b)]
            i3 = z^k
            bfs+=[(i+1,i3,pr*c)]
    ex = 0
    for I in bfs:
        i = I[-1]
        val = I[1]
        ex += (i*val)
    ex /= float(den)
    print "%0.11f"%ex
    
    
