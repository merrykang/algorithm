from collections import deque
def solution(maps):
    dx = [-1,1,0,0]; dy = [0,0,-1,1]
    def bfs(x, y):
        q = deque()
        # nonlocal cnt 배움
        q.append((x, y))  # 큐에 뭐 넣어?, 큐에 값을 넣었다 빼는 시기? A. 지금 pop 하지 않으면 i 반복문마다 pop 해서 index error (큐 비었는데 pop 하려고 함) / q.append((x, y)) 와의 차이: x, y = queue.popleft() 이렇게 사용 가능 
        while q: 
            x, y = q.popleft()
            for i in range(4):  # 굳이 len() 계산할 필요없음
                # print('n ', n)
                nx = x + dx[i]; ny = y + dy[i]  # now X, now Y라는 뜻
                # 맵 벗어나면 무시
                if nx < 0 or ny < 0 or nx > len(maps) - 1 or ny > len(maps[0]) - 1: continue
                # 벽 있으면 리턴 1 ? 무시 ?
                if maps[nx][ny] == 0: continue
                # 방문 체크: 인덱스를 q.append (함수 맨 앞임) -> 다시 함수 호출
                if maps[nx][ny] == 1:
                    # UnboundLocalError: local variable 'cnt' referenced before assignment
                    # maps[nx][ny] = maps[x][y] + 1 인 이유: maps[x][y]이 cnt 역할
                    maps[nx][ny] = maps[x][y] + 1
                    q.append((nx, ny))
                    # print('q: ', q)
                    # bfs(nx, ny)  # 그런데 여기서 바로 호출하면 나머지 i는 안 돌아? A. 따라서 bfs 함수를 호출하는게 아니라 걍 q에 append 하면 됨
        # print('maps: ', maps)
        return maps[len(maps) - 1][len(maps[0]) - 1]  # 2차원 리스트에서 x, y 길이 계산 주의
    ans = bfs(0,0)
    return -1 if ans == 1 else ans
    # 동서남북 표현: [-1,1,0,0], [0,0,-1,1] -> x, y
    # 그래프는 이미 있음. 그 그래프를 동서남북으로 탐색하면 됨
    # 예외: 상대팀 진영에 벽 있는 경우 -> -1 리턴 
    """
    현재 생각
     1. 1만 따라 간다?
     2. (n-1, m) == 1 and (n, m-1) == 1 이면 return -1 
     3. 방문 배열이 필요할듯: v = [[0] * i for i in range(len(maps))]
      - 이때 len 이 세로인지 가로인지 모르겠음 A. 내 생각 len 세로, len(maps[0]) 가로
     4. 방문 배열을 어떻게 사용? 방문하면 1 표시
      - (n, m) 이었을 때 리턴하면 자연스럽게 최단 거리 찾게 됨 -> 그러면 수 1개 키워서 하는게 노소용 아닌가
      - 재귀함수 써야할듯
      - 어떻게 반복할지 막막
     5. 양 끝 값 처리 ? A. 맵을 벗어나면 무시(continue) -> 괜히 크게 배열 만들기 X
     6. 최단거리 문제면 BFS일 가능성이 높음
      - 큐에 넣고 방문 처리: v 배열을 별도로 만들어도 되지만 위 문제는 굳이 그럴 필요없음.
        걍 map에다가 숫자 더해서 표시하면 됨
      - 현재 좌표 처리: for 문으로 4번 돌면서 dx, dy 구하기
      - solution 함수 안에다가 bfs 함수 정의
    """