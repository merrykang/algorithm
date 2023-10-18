def solution(priorities, location):
    queue =  [(i,p) for i,p in enumerate(priorities)]
    ans = 0
    while True:
        cur = queue.pop(0)
        if any(cur[1] < q[1] for q in queue):
            queue.append(cur)
        else:
            ans += 1
            if cur[0] == location:
                return ans