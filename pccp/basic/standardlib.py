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


#################################################################################################


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


#################################################################################################


# heapq : 힙은 안정적인 자료구조; 시간복잡도는 O(n log n)

# 최소 힙
# import heapq

# print("============= 기본 : 최소 힙 =================")
## heapq.heappush(h, val) : 힙에 값을 삽입, heapq.heappop(h) : 힙에서 가장 작은 값을 추출
## 최소 힙(Min Heap)이라고 가정하면, 힙에 값을 삽입하면 항상 힙의 루트(가장 작은 값)에는 가장 작은 값이 위치


# def heapsort(iterable):
#     h = []
#     ans = []
#     # 모든 원소를 차례대로 힙에 삽입
#     for val in iterable:
#         heapq.heappush(h, val)
#     print(h)  # [1, 3, 2, 6, 9, 5, 4, 7, 8, 9] : heapsort 함수에 인자값으로 들어온 배열
#     # 힙에 삽입된 모든 원소를 차례대로 꺼내어 담기
#     for _ in range(len(h)):
#         ans.append(heapq.heappop(h))  # 오름차순 정렬되는 코드 : 리스트 h의 가장 작은 값부터 힙에 삽입됨
#     return ans


# ans = heapsort([1, 3, 5, 7, 9, 2, 4, 6, 8, 9])
# print(ans)  # [1, 2, 3, 4, 5, 6, 7, 8, 9, 9]


# 최대 힙 : 원소의 부호를 통해 구현
# print("============= 기본 : 최대 힙 =================")


# def heapsort1(iterable):
#     h1 = []
#     res1 = []
#     for val in iterable:
#         heapq.heappush(h1, -val)  # -val로 담아야 최솟값인 -9부터(실제로는 최댓값) 꺼낼 수 있음을 잊지 말 것!
#     print(h1)  # [-9, -8, -4, -7, -5, -2, -3, -1, -6, 0]

#     # 힙에 삽입되 원소를 차례대로 꺼내어 담기 : 최댓값부터 삽입됨
#     for _ in range(len(h1)):
#         res1.append(
#             -heapq.heappop(h1)
#         )  # 코드 실행 순서 : 최솟값인 -9부터 pop -> 그 값들에 다시 마이너스 부호 취하기
#     return res1


# res1 = heapsort1([1, 3, 5, 7, 9, 2, 4, 6, 8, 0])
# print(res1)  # [9, 8, 7, 6, 5, 4, 3, 2, 1, 0]


#################################################################################################


# bisect: 이진 탐색 구현
# from bisect import bisect_left, bisect_right

# arr2 = [1, 2, 4, 4, 8]
# x = 4
# print(bisect_left(arr2, x))  # 2 : arr2에 x를 삽입하려고 할 때 왼쪽부터 count 하는 경우 적합한 인덱스
# print(bisect_right(arr2, x))  # 4 : arr2에 x를 삽입하려고 할 때 오른쪽부터 count 하는 경우 적합한 인덱스


## 정렬된 리스트에서 값이 [left value, right value]에 속하는 데이터 개수
# def count_by_range(arr3, lval, rval):
#     ridx = bisect_right(arr3, rval)
#     print("right index : ", ridx)
#     lidx = bisect_left(arr3, lval)
#     print("left index : ", lidx)
#     return ridx - lidx


# arr3 = [1, 2, 3, 3, 3, 4, 4, 8, 9]
# print(count_by_range(arr3, 4, 4))  # 2 : right index :  7 - left index :  5
# print(count_by_range(arr3, -1, 3))  # 5 : right index :  5 - left index :  0


#################################################################################################


# collections
## deque : 큐 구현; 인덱싱, 슬라이싱 불가 -> 사용하고 싶으면 리스트로 바꾸고 사용해야함
# print("============= deque : append(), pop() =================")
# from collections import deque

# que = deque([2, 3, 4])
# que.appendleft(1)  # 첫 번째 자리에 원소 추가
# que.append(5)  # 마지막 자리에 원소 추가
# print(que)  # deque([1, 2, 3, 4, 5])
# print(list(que))  # [1, 2, 3, 4, 5]

# que.popleft()
# print(que)  # 첫 번째 원소 꺼내기 : deque([2, 3, 4, 5])
# que.pop()  # 마지막 원소 꺼내기
# que.pop()
# print(list(que))  # [2, 3]

## Counter : 등장 횟수(객체 내에 원소 개수가 몇개 있는지)를 세는 기능
# print("============= Counter =================")
# from collections import Counter

# cnt = Counter(["red", "blue", "red", "green", "blue", "blue"])
# print("'blue'가 나온 횟수: ", cnt["blue"])  # 3
# print("'red'가 나온 횟수: ", cnt["red"])  # 2
# print("'green'가 나온 횟수: ", cnt["green"])  # 1
# print(dict(cnt))  # {'red': 2, 'blue': 3, 'green': 1} : 사전 자료형(key-value로 변환)


#################################################################################################


# math
# import math

# print(math.factorial(5))  # 120 = 5!
# print(math.sqrt(7))  # 2.6457513110645907 = 루트 7
# print(math.gcd(21, 14))  # 7 : 21과 14의 최대공약수
# print(math.pi)  # 3.141592653589793 = 파이값
# print(math.e)  # 2.718281828459045 = 자연 상수 e
