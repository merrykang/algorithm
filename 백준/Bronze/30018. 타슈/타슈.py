N = int(input())
A = list(map(int, input().split()))
B = list(map(int, input().split()))
diff = []

for i in range(N):
    diff.append(abs(B[i] - A[i]))
ans = sum(diff) // 2
print(ans)