# N = int(input())
# LOST = list(map(int, input().split()))
# REVERSE = list(map(int, input().split()))


def solution(n, lost, reserve):
    answer = 0

    reserve_del = set(reserve) - set(lost)
    lost_del = set(lost) - set(reserve)

    for i in reserve_del:
        if i - 1 in lost_del:
            lost_del.remove(i - 1)

        elif i + 1 in lost_del:
            lost_del.remove(i + 1)

    answer = n - len(lost_del)

    return answer


# def solution(N, L, R):
#     ans = N - len(L)
#     for i in range(len(R)):
#         for j in range(len(L)):
#             if R[i] == L[j]:
#                 L.pop(j)  # j에 해당하는 값만 pop 됨
#                 break
#             elif R[i] + 1 == L[j] or R[i] - 1 == L[j]:
#                 ans += 1
#                 L.pop(j)  # j에 해당하는 값만 pop 됨
#                 break
#         if len(L) < 1:
#             break  # L이 빈 배열이면 break 되어야함
#     return ans


# def solution(n, lost, reverse):
#     lost.sort()
#     reverse.sort()

#     # 예외: 공통 숫자 지우기
#     new_lost = set(lost) - set(reverse)
#     new_reverse = set(reverse) - set(lost)
#     answer = n - len(new_lost)
#     # for i in reverse[:]:
#     #     if i in lost[:]:
#     #         lost.remove(i)
#     #         reverse.remove(i)

#     # 일반: 이웃 원소 탐색
#     for i in new_lost:
#         if (i + 1) in new_reverse:
#             answer += 1
#             new_reverse.remove(i + 1)
#         elif (i - 1) in new_reverse:
#             answer += 1
#             new_reverse.remove(i - 1)

#     # answer = n - len(new_lost)

#     return answer
