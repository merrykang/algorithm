N, K = map(int, input().split())

ans = 0
while N != 1:
    if N % K == 0:
        N = int(N / K)
        ans += 1
    elif N % K != 0:
        N = N - 1  # N -= 1 �� �� �� �����ϰ� ���� �� ����
        ans += 1
print(ans)
