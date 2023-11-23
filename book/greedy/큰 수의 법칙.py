N, M, K = map(int, input().split())
NUM = list(map(int, input().split()))

"""
1. 정렬
2. set 만들기 : set = max + 그 다음 max 
3. ans = 세트 * 몫 + max * 나머지 
3. ans 출력 
"""
NUM.sort()  # 2 4 4 5 6

set = NUM[N - 1] * K + NUM[N - 2]

ans = set * (M / (K + 1)) + NUM[N - 1] * (M % (K + 1))
print(int(ans))

## 오답 이유 : max K번 - 다른 숫자 - max K번 이 가능하기 때문, 즉 보다 커질 수 있는 가능성 있음
# ans = 0
# cnt = 0
# for i in range(M):
#     if cnt > M:
#         break
#     for j in range(K):
#         ans += NUM[N - i - 1]
#         cnt += 1
