def solution(prices):
    t = [0] * len(prices)
    s = []
    # 인덱스를 append 하는 생각 못 함
    # 가격이 떨어지는 경우 / 마지막까지 떨어지지 않은 경우로 나누어서 생각할 생각 하지 못 함
        # 마지막에 t 만 처리할 수 없나: 전부 ? 일부? -> 그 이유: 마지막까지 떨어지지 않은 경우임
        # 가격이 떨어지는 경우(핵심 로직): 스택의 pop 인덱스의 prices 가 이전 인덱스의 첫 번째 가격 떨어짐이 될 수 있다
        # 가격이 떨어지지 않은 경우(핵심 로직): s가 있을 때까지
    for i in range(len(prices)):  # 결국 반복문 2번 돌리긴 함
        while s and prices[s[-1]] > prices[i] :  # while인 이유 = 반복문 + 조건문(현재 pop 인덱스의 prices가 i 인덱스의 첫 번째 가격 떨어짐이었는데, i-1 i-2 의 경우에도 첫 번째 가격 떨어짐일 수 있음) / list index out of range 고려하여 s 있는지 여부 따져야함
            j = s.pop()
            t[j] = i - j
        s.append(i)        
    while s:
        k = s.pop()
        t[k] = len(prices) - k - 1
    return t