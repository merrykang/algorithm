from collections import deque

def solution(pri, loca):
    ans = 0
    q = deque()  # 문제에서 대놓고 큐라고 힌트 줬으니까 사용하는게 좋음
    check = []
    for idx, val in enumerate(pri):
        q.append([idx,val])  # idx와 val 한 번에 append 할 때는 이렇게!
    
    while len(pri) >= ans:
        check = q[0]
        # print(check)
        # print('check[1]: ', check[1])
        max_pri = max(val[1] for val in q)
        # print('max_pri: ', max_pri)
        # print('ans: ', ans)
        if check[1] == max_pri:
            # print('q1: ', q)
            if check[0] == loca:
                ans += 1
                return ans
            else: 
                ans += 1
                q.popleft()
                continue
        q.popleft()
        q.append(check)
        # print('q: ', q)
                
    # answer = 1
    # check = []
    # pri_copy = pri
    # max_num = max(pri_copy)
    # while len(check) < len(pri):
    #     for i in range(len(pri)):
    #         if pri[i] == max_num:
    #             check.append(pri[i])
    #             del pri[i]
    #             max_num = max(pri_copy)
    #             # 리턴 조건 필요해
    #             if i == loca:
    #                 return len(check)
    
    
    # while len(check) < len(pri):
    #     for i in range(len(pri)):
    #         if pri[i] == max(pri):
    #             check.append(pri[i])
    #             del pri[i]
    #             # pri.remove(pri[i])  # 리스트의 특정 인덱스 값 삭제: remove 가 아니라 del 
    #             print(pri)
    #             if i == loca:
    #                 return len(check)
    #             break
                
                
                
        # return 0  # while 문 멈추려면 break 또는 return 
    # check = []
    # check_one = []
    # num = pri[loca]
    # pri_len = len(pri) - 1
    # for i in pri:
    #     if i > num:
    #         check.append(1)
    #     elif i < num:
    #         check.append(2)
    #     else: 
    #         check.append(3)
    # if check.count(1) == 0:
    #     for j in range(len(check)):  # in 아니고, in range of 아니고, in range()
    #         if j == loca:
    #             break
    #         elif check[j] == 3:
    #             answer += 1
    # else:
    #     for k in range(len(check)):
    #         if check[k] == 2: 
    #             pri_len -= 1
    #         elif check[k] == 1:
    #             check_one.append(k)
    # print(check_one)
                    
        
        
