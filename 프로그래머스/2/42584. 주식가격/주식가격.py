def solution(prices):
    stack = []
    answer = [0] * len(prices)
    for i in range(len(prices)):
        while stack and prices[i] < prices[stack[-1]]:
            j = stack.pop()
            answer[j] = i - j
        stack.append(i)
    while stack:
        j = stack.pop()
        answer[j] = len(prices) - 1 - j
    return answer

# def solution(prices):
#     ans = [0] * len(prices)
#     for i in range(len(prices)):
#         if i == len(prices) - 1:
#             # ans[i] -= 1
#             return ans
#         for j in range(len(prices)):
#             if i >= j: continue
#             ans[i] += 1
#             if prices[i] > prices[j]: break
#             # else: ans[i] += 1 
