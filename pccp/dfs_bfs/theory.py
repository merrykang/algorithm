"""
개요
    - 탐색 : 원하는 데이터를 찾는 과정 
    - 자료 구조: 데이터를 표현, 관리, 처리하는 구조 
    - dfs, bfs를 공부하려면 선행적으로 스택, 큐, 재귀 함수 공부해야함 
    - 스택, 큐에서의 오버플로 및 언더플로
        - 오버플로 : 자료 구조가 수용할 수 있는 크기가 꽉 찬 상태에서 데이터 삽입 수행
        - 언더플로 : 자료 구조에 데이터가 들어 있지 않은데 데이터 삭제 수행
"""

"""
스택 = 박스쌓기 : 나중에 들어온 사람이 먼저 나감 = 후입선출 = LIFO(Last In First Out)
    - 별도의 라이브러리 import 필요없음
"""
# s = []
# s.append(5)
# s.append(2)
# s.append(3)
# s.append(7)
# print(s)  # [5, 2, 3, 7]
# s.pop()
# print(s)  # [5, 2, 3] : 나중에 들어온게 먼저 나감
# s.append(1)
# s.append(4)
# print(s)  # [5, 2, 3, 1, 4]
# s.pop()
# print(s)  # [5, 2, 3, 1] : 최하단 원소( = 먼저 들어온 것)부터 출력
# print(s[::-1])  # [1, 3, 2, 5] : 최상단 원소(= 나중에 들어온 것)부터 출력


"""
큐 = 대기 줄 = 먼저 들어온 사람이 먼저 나감 = First In First Out(FIFO) = 선입선출
    - 라이브러리 import 필요 : from collections import deque
    - queue 라이브러리보다 deque 라이브러리가 속도, 효율성 측면에서 더 우월함
"""
# from collections import deque

# que = deque()
# que.append(5)
# que.append(2)
# que.append(3)
# que.append(7)
# print(que)  # deque([5, 2, 3, 7])
# que.popleft()
# print(que)  # deque([2, 3, 7]) : 선입선출이지만 코드로는 popleft라고 써야함
# que.pop()
# print(que)  # deque([2, 3]) : pop은 일반 상식처럼 맨 오른쪽 원소가 나가게 됨
# que.append(1)
# que.append(4)
# print(que)  # deque([2, 3, 1, 4])
# que.reverse()
# print(que)  # deque([4, 1, 3, 2]) : 필요에 의해 순서 뒤바꿈
# print(list(que))  # [4, 1, 3, 2] : 자료 접근 (인덱싱) 할 수 있게 리스트로 바꿈
# lque = list(que)
# print(lque[0])


"""
* 2차원 배열 + 탐색 문제 : 무조건 그래프 형태로 바꿔서 DFS, BFS 이용
재귀함수(Recursive function) : 자기 자신을 호출하는 함수
    - 필수 요소 : 1) 종료 조건 2) return문
    - 종료 조건을 꼭!!! 명시해야함 : 보통 함수 시작하자마자 명시, if 문 많이 사용 
    - 컴퓨터 내부에서 스택 자료 구조 이용 : 따라서 재귀 함수는 스택 자료 구조와 같다고 함 
        = 마지막에 호출된 함수가 수행 끝내야 그 앞의 함수 호출이 종료됨 
    - 일반 반복문 대신 재귀함수 쓰는 이유: 코드가 보다 간결
    - 뭔가 점화식 느낌 : 따라서 dfs, bfs 공부 후 -> dp 공부하는게 좋음 
        - 즉, 스택큐 + (점화식) + dfs, bfs + dp는 한 세트!
"""


# 반복적으로 구현한 n!
# def iterative(n):
#     res = 1
#     # n까지의 수를 차례대로 곱하기: n+1까지 써야 n까지 곱하게 됨
#     for i in range(1, n + 1):
#         res *= i
#     return res


# # 재귀적으로 구현한 n!
# def recursive(n):
#     if n <= 1:
#         return 1
#     # n까지의 수를 차례대로 곱하기
#     return n * recursive(n - 1)  # 자기 자신 호출


# print("반복적으로 구현한 n!: ", iterative(5))  # 120
# print("반복적으로 구현한 n!: ", recursive(5))  # 120


""" 
* 2차원 배열 + 탐색 문제 : 무조건 그래프 형태로 바꿔서 DFS, BFS 이용
DFS(Depth-First Search) : 깊이 우선 탐색 = 그래프에서 깊은 노드 먼저 탐색 = 최대한 멀리 있는 노드부터 탐색 
    - 핵심 특징 : 스택 이용, 재귀함수 이용
    - 그래프 탐색 관련 개념 
        - 그래프 탐색 : 하나의 노드부터 시작하여 더이상 방문 처리할 노드가 없을 때까지 방문하는 것 
        - 노드가 인접 : 두 노드가 간선으로 연결되어 있는 것
        - 그래프 연결 방식 
            1. 인접 행렬 : 2차원 배열로 그래프 연결 관계를 표현
                - 모든 관계를 저장 : 메모리 비효율적 사용 
            2. 인접 리스트 : 리스트로 그래프 연결 관계 표현
                - 연결된 정보만 저장 : 메모리 효율적 사용, but 정보를 얻는 속도 느림 
    - 동작 과정 
        1. 탐색 시작 노드 1개를 스택에 삽입 -> 방문 처리 
        2. 스택의 최상단 노드(현재 위치)에 방문하지 않는 인접 노드가 있으면 그 인접 노드를 스택에 넣고 방문처리 
            -> 방문하지 않은 인접 노드가 없으면 스택에서 최상단 노드를 꺼냄 
            - 인접 노드가 여러개 : 번호가 낮은 순서(가장 작은 노드)부터 처리
        3. 2번을 더이상 수행할 수 없을 때까지 반복
    - 시간 복잡도 : 데이터가 n개라면 O(N)
"""


"""
BFS(Breadth First Search) : 너비 우선 탐색 = 가까운 노드부터 탐색
    - 핵심 특징 : 큐 사용, 큐 자료 구조 이용(deque 라이브러리) / 실제 수행시간이 DFS보다 빠름
    - 동작 과정 
        1. 탐색 시작 노드를 큐에 삽입하고 방문 처리 (=스택과 동일)
        2. 인접 노드 중 방문하지 않은 모든 노드를 큐에 삽입(2개 이상 가능) -> 방문 처리 
        3. 2번을 수행할 수 없을 때까지 반복
    - 시간 복잡도 : 데이터가 n개라면 O(N)
"""
