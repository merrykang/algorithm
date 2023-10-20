"""
실전 문제2 : 미로 탈출
"""

# input 받고 확인
n, m = map(int, input().split())
print(n, m)  # 5 6
g = []
for i in range(n):
    g.append(list(map(int, input())))
print(
    g
)  # [[1, 0, 1, 0, 1, 0], [1, 1, 1, 1, 1, 1], [0, 0, 0, 0, 0, 1], [1, 1, 1, 1, 1, 1], [1, 1, 1, 1, 1, 1]]
print(g[2][1])  # 0 : 인덱싱 : 행 0~4, 열 0~5

"""답"""
from collections import deque

# 이동할 네 방향 정의(상, 하, 좌, 우) : dx, dy : 이동 변화폭 적어놓는 느낌
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


# BFS 소스 코드 구현
def bfs(x, y):
    que = deque()
    que.append((x, y))
    print(que)  # deque([(0, 0)])

    # 큐가 빌 때까지 반복
    while que:
        print(que)
        x, y = que.popleft()
        print(x, y)  # 0,0

        # 현재 위치에서 네 방향으로의 위치 확인
        ## i=0 : 좌, i=1 : 우, i=2 : 상, i=3 : 하
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            # 제약 조건
            ## 1. 미로 찾기 공간을 벗어난 경우 무시
            # -> 나의 한계 1: out of range 해결 못 함; 맨 마지막 칸이 n-1, m-1이므로 n, m을 경계선으로 잡아야함
            if nx < 0 or ny < 0 or nx >= n or ny >= n:
                continue
            ## 2. 괴물인 경우 무시
            # -> 나의 한계 : n+1, m+1 사용하여 out of range (그러나 상하좌우만큼 for문 사용하면 굳이 n+1, m+1 사용할 필요 없음)
            if g[nx][ny] == 0:
                continue

            # 본 조건 : 해당 노드를 처음 방문하는 경우에만 최단 거리 기록
            ## 나의 한계 2 : 업데이트 해야하는 값을 무조건 현재 x, y 라고 생각함
            ## 그러나 실제 구조 : 다음 x, y 값 업데이트하고 큐에 append -> 다음 값이 현재 값이 되었을 때 큐에서 pop
            if g[nx][ny] == 1:
                g[nx][ny] = g[x][y] + 1
                que.append((nx, ny))
    return g[n - 1][m - 1]


# 결과 출력
print(bfs(0, 0))

""" 나의 풀이 
한계 
    1. out of range : g를 map한 결과 때문에 x+1, y+1을 사용할 수 없음 -> 다른 방법 찾아야 했지만 생각 못했음 
    2. bfs인가? : 생각은 했지만, 1) 왜 bfs 인지 2) 그걸 어떻게 코드로 표현해야 하는지 몰랐음 
    3. 제약 조건 : 일부는 맞았지만, 아직 정확하게 생각하지 못함 -> 나만의 제약 조건 찾는 루틴 찾아야할 필요 있음
"""
"""
# 방문
for x in range(n):
    for y in range(m):
        # 방문 시작점은 무조건 1 = 동빈이 위치
        if x == 0 & y == 0:
            g[x][y] = 1
        # 마지막 위치인 경우 무조건 더하기
        if x == n - 1 & y == m - 1:
            if g[x - 1][y] > 1:
                g[x][y] = g[x - 1][y] + 1
            elif g[x][y - 1] > 1:
                g[x][y] = g[x][y - 1] + 1

        # 괴물 있는 경우는 값 변경하지 않고 넘어가기 = 값이 0
        if g[x + 1][y] == 0 or g[x][y + 1] == 0:
            continue
        # 현재 위치보다 우, 하만 확인 : 어차피 그 쪽으로만 이동할 것
        if g[x + 1][y] != 0:
            g[x + 1][y] = g[x][y] + 1
        elif g[x][y + 1] != 0:
            g[x][y + 1] = g[x][y] + 1

# 답 출력
ans = g[n - 1][m - 1]
print(ans)
"""
