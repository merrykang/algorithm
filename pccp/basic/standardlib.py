# 내장 함수: 별도의 import 없이 사용 가능한 함수
# print("================ sum() =================")
# ans = sum([1, 2, 3, 4, 5])
# print(ans)  # 15

# print("================ min(), max() =================")
# ans1 = min(4, 7, 5, 2)
# print(ans1)  # 2 : 2개 이상의 파라미터 입력 가능 : 같은 형식으로 max()도 이용 가능

# print("================ eval() =================")
# ans2 = eval("(3+5)*7")
# print(ans2)  # 56 : 수식이 문자열 형식으로 들어오면 해당 수식을 계산한 결과를 반환

# print("================ sorted() =================")
# ans3 = sorted([9, 1, 8, 5, 4])
# print(ans3)  # [1, 4, 5, 8, 9] : 오름차순 정렬
# [9, 8, 5, 4, 1] : reverse=True 내림차순 정렬
# ans4 = sorted([9, 1, 8, 5, 4], reverse=True)
# print(ans4)
# ans5 = sorted([('홍길동', 35), ('이순신', 75), ('아무개', 50)],
#               key=lambda x: x[1], reverse=True)
# [('이순신', 75), ('아무개', 50), ('홍길동', 35)] : 두번째 컬럼을 기준으로 정렬(key 옵션) : 내림차순 정렬(reverse=True)
# print(ans5)
# arr = [9, 1, 8, 5, 4]
# arr.sort()
# print(arr)  # [1, 4, 5, 8, 9] : 그러나 리스트(1차원 배열)는 이미 sort 함수로 위 내용 구현 가능


# itertools
# from itertools import permutations
# from itertools import product
# from itertools import combinations
# from itertools import combinations_with_replacement

# print("================== Permutations =================")
# arr1 = ['A', 'B', 'C']
# ans6 = list(permutations(arr1, 2))
# # [('A', 'B'), ('A', 'C'), ('B', 'A'), ('B', 'C'), ('C', 'A'), ('C', 'B')] : 순열, 중복 허용X ('A', 'A')
# print(ans6)
# ans7 = list(product(arr1, repeat=2))
# # [('A', 'A'), ('A', 'B'), ('A', 'C'), ('B', 'A'), ('B', 'B'), ('B', 'C'), ('C', 'A'), ('C', 'B'), ('C', 'C')] : 순열, 중복 허용O(ex. ('C', 'C'))
# print(ans7)

# print("================== Combinations =================")
# ans8 = list(combinations(arr1, 2))
# print(ans8)  # [('A', 'B'), ('A', 'C'), ('B', 'C')] : 조합, 중복 허용X
# ans9 = list(combinations_with_replacement(arr1, 2))
# print(ans9)  # [('A', 'A'), ('A', 'B'), ('A', 'C'), ('B', 'B'), ('B', 'C'), ('C', 'C')] : 조합, 중복 허용O(ex. ('C', 'C'))


# heapq
import heapq
print("============= 기본 : 최소 힙 =================")


def heapsort(iterable):
    h = []
    ans = []
    # 모든 원소를 차례대로 힙에 삽입
    for val in iterable:
        heapq.heappush(h, val)
    # 힙에 삽입된 모든 원소를 차례대로 꺼내어 담기
    for _ in range(len(h)):
        ans.append(heapq.heappop(h))
    return ans


ans = heapsort([1, 3, 5, 7, 9, 2, 4, 6, 8, 9])
print(ans)

# bisect

# collections

# math
