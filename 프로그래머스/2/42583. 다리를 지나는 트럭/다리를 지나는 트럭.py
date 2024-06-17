from collections import deque

def solution(bridge_length, weight, truck_weights):
    t = 0; currentW = 0
    truck_weights = deque(truck_weights) 
    currentL = deque([0] * bridge_length)
    
    # while truck_weights 또는 while len(lastWeight) < len(초기 truck_weights)
    while len(truck_weights) > 0:
        # curreuntW -= currentL.popleft()  # 다리를 지난 트럭 무게 제외
        l = currentL.popleft()
        currentW -= l
        if currentW + truck_weights[0] <= weight:
            w = truck_weights.popleft()
            currentL.append(w)
            currentW += w
        else: 
            currentL.append(0)
        t += 1
    t += bridge_length
    # sum(currentW) <= weight: +truck_weights.popleft(); time+=1; continue
    # 무게 > weight: currentW.append(0) ; time 건드리지 않아
    # (기본으로) t += bridge_length
    # truck_weights 의 첫 번째인 경우
    return t