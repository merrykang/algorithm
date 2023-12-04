N = int(input())
A = list(map(int, input().split()))
B = list(map(int, input().split()))
diff = []

for i in range(N):
    diff.append(abs(B[i] - A[i]))
# diff.sort()
# if diff[0] == diff[N - 1]:
#     ans = max(diff) * (N // 2)
# else:
#     ans = max(diff)
ans = sum(diff) // 2
print(ans)
