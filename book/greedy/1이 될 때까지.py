N, K = map(int, input().split())

ans = 0
while N != 1:
    if N % K == 0:
        N = int(N / K)
        ans += 1
    elif N % K != 0:
        N = N - 1  # N -= 1 로 좀 더 간단하게 적을 수 있음
        ans += 1
print(ans)
