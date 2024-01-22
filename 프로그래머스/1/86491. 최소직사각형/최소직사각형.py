def solution(sizes):
    answer = 0
    big = []
    small = []
    
    for size in sizes:
        if size[0] >= size[1]:
            big.append(size[0])
            small.append(size[1])
        else:
            big.append(size[1])
            small.append(size[0])
    answer = max(big) * max(small)
    return answer