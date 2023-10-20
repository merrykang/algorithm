"""
실전 문제1: 음료수 얼려 먹기

"""
# 정보 입력 받기
## n, m 정보 입력 받기
n, m = map(int, input().split())
print(n, m)  # 4 5

## graph 정보 입력 받기 : 이렇게 정보 받아오면 g[dx][dy]로 접근 가능
g = []
for i in range(n):  # graph에 위 이론 공부할 때처럼 연결 정보같은 것이 리스트로 들어가야 하니까 range(행 수)만큼 돌기
    g.append(list(map(int, input())))  # 리스트에는 append 사용; split()할 것이 없으니까 안 써도 됨
print(g)  # [[0, 0, 1, 1, 0], [0, 0, 0, 1, 1], [1, 1, 1, 1, 1], [0, 0, 0, 0, 0]]
print(g[1][1])


# dfs 정의
def dfs(dx, dy):
    """
    종료 조건 : 주어진 범위를 벗어나는 경우
        (1차 시도) : if dx <= 0 | dy <= 0 | dx >= m + 1 | dy >= m + 1 -> but 이는 리스트의 인덱스가 0~m or n까지 있음을 간과한 것
        (2차 시도) : if dx <= -1 | dy <= -1 | dx >= m | dy >= m -> but 이는 dx의 경우 제한이 n임을 간과한 것
    """
    if dx <= -1 or dy <= -1 or dx >= n or dy >= m:  # 파이썬에서는 or 표시가 |가 아님
        return False

    """
    방문
        - (1차 시도) : 어떤 경우에 방문할 것인지 누락 -> 아직 방문하지 않은 노드인경우
        - 방문 표시에 대한 설명 연결된 부분(0으로 표시)을 1로 바꾸기 : 그럼 나중에는 모든 노드가 1이 됨
            - 그래도 상관없음: 왜냐하면 return True와 return False 는 재귀 호출 스택이라는 리스트 g와 다른 저장 공간에 저장되기 때문
            - 따라서 나중에 dfs(dx, dy) == True인지를 확인하는 것은 재귀 호출 스택을 확인하는 것이라고 볼 수 있음 
            : 이것은 g[dx][dy]==1인지 그 리스트에 대한 값을 확인하는 것과는 다름
    """
    # 방문 해야 하는 노드에 대해 = 연결되어있는 노드 = 상하좌우를 확인해야 하는 노드
    if g[dx][dy] == 0:
        # 해당 노드 방문 처리
        g[dx][dy] = 1
        dfs(dx, dy + 1)
        dfs(dx, dy - 1)
        dfs(dx - 1, dy)
        dfs(dx + 1, dy)
        return True
    return False


"""
정답 도출 : 재귀 호출 스택에 있는 값이 True인지 확인 = dfs(dx, dy) = True인지 확인
"""
ans = 0
for i in range(n):
    for j in range(m):
        if dfs(i, j) == True:
            ans += 1  # 파이썬에서는 ans++ 같은 형태의 식 사용 불가

print(ans)
