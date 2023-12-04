N = int(input())
MILK = list(map(int, input().split()))
ans = m = 0

for i in range(N):
    if MILK[i] == m:
        ans += 1
        if m == 2:
            m = 0
        else:
            m += 1
    else:
        continue
print(ans)
