T = int(input())
C = []
for i in range(T):
    C = list(map(int, input().split()))
    Q = D = N = P = 0
    Q = C[0] // 25
    D = C[0] % 25 // 10
    N = (C[0] % 25) % 10 // 5
    P = ((C[0] % 25) % 10) % 5 // 1
    print(Q, D, N, P)