from collections import deque
def solution(numbers, target):
    cnt = 0
    q = deque(); numbers = deque(numbers); s = deque()
    # 뭔가 뺴고 더하는 로직 필요해 -> 뺴고 더하는 만큼 전체의 큰 matrix를 만드는 느낌
    # (+1, -1 되는 큰 바둑판 캡처)
    # 큰 매트릭스를 어떻게 만들지: 2개 -> 4개 -> 8개 식으로 됨
    # 마이너스, 플러스 된 애들 각각 append 해야함. 그 과정의 숫자들을 다 q에 두는 걸까. 어떻게 두지
    ## 문제: 바로 append 하면 반복하는 q가 달라짐 -> 따라서 다른 stack에 두고 마지막에 대체
    ## 즉, 스택 큐 다 합쳐서 3개 쓰는 느낌
    while numbers:
        n = numbers.popleft()
        if len(q) == 0:  #!q가 아니라 len 함수로 비었는지 확인하자
            q.append(-n)  # 다음 원소 뽑아서 기존의 원소에 더하고 빼는 방법? 돌면서 빼고 더해야 하나
            q.append(n)
            # print('q1: ', q)
            continue
        while q:
            current = q.popleft()
            s.append(current - n)
            s.append(current + n)
            # break
        q = s
        s = deque()
    # print('q: ', q)
    # print('s: ',s)
    while q:
        m = q.popleft()
        if m == target: cnt += 1
    # 위의 +1, -1 과정 거쳐서 다 돌고 -> 큐로 하나씩 빼면서? 원하는 값이면 리턴
    # 시간 초과 -> 왜?
    return cnt