# input
N, M = map(int, input().split())
CARD = []
num = []
for i in range(N):
    card = list(map(int, input().split()))
    CARD.append(card)
    num.append(min(CARD[i]))
print(CARD)
ans = max(num)
print(ans)
