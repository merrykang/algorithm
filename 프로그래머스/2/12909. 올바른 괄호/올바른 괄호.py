def solution(s):
    check = []
    for i in s:
        if i == '(':
            check.append(i)
        else:
            if len(check) == 0:
                return False
            else:
                check.pop()
    return len(check) == 0
    # if len(check) == 0:
    #     return True
    # else:
    #     return False
        
        # if len(check) == 0 and i == ')':  # check.length 아니고 len(check) 
        #     return False  # 참 또는 거짓: 시작이 대문자
        # check.append(i)  # check.push 아니고 check.append
        # print(check[-1])

