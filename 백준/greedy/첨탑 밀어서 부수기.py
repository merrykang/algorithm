N = int(input())
H = list(map(int, input().split()))
ans = 0

for i in range(N):
    if i == 0:
        ans += 1
        continue
    else:
        if H[i - 1] > H[i]:
            continue
        elif H[i - 1] <= H[i]:
            ans += 1
print(ans)
