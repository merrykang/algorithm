N = int(input())
V = list(map(int, input().split()))
V.pop(V.index(max(V)))
print(sum(V))
