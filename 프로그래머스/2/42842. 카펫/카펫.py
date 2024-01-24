def solution(brown, yellow):
    answer = []
    yellow_wh = (brown-4)/2
    i=1
    while i <=  yellow_wh//2:
        if i * (yellow_wh-i) == yellow:
            answer.append((yellow_wh-i)+2)
            answer.append(i+2)
            break
        i=i+1
    return answer