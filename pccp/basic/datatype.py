# 수 자료형

# 실수형을 정확히 비교하려면 round() 함수가 필요
# a = 0.3+0.6
# print(a)  #0.8999999999999999
# print(round(a, 5))  # round(실수, 반올림 위치-1)
# b = 0.42+0.89
# print(b)  #1.31
# print(round(b, 1))  #1.3

# 연산: 나머지(%), 몫(//), 거듭제곱(**)
# a1 = 7
# b1 = 3
# print(a1/b1)  # 나눈 전체 수 : 2.3333333333333335
# print(a1%b1)  # 나머지: 1
# print(a1//b1)  # 몫: 2
# print(a1**b1)  # 거듭제곱: 343


# 리스트 자료형
# 리스트 만들기
# a2 = [1,2,3,4,5,6,7,8,9]
# print(a2)  # 리스트(배열) 초기화: [1, 2, 3, 4, 5, 6, 7, 8, 9]
# print(a2[5])  # 6 : 인덱싱
# b2 = list()
# print(b2)  # 빈 리스트 선언 : []
# b2 = []
# print(b2)  # 빈 리스트 선언 : []


# 리스트의 인덱싱과 슬라이싱
# 인덱싱: 원소 1개에 접근
# a3 = [1,2,3,4,5,6,7,8,9]
# print(a3[-1])  # 9 : 제일 마지막 원소에 접근

# 슬라이싱: 연속적인 원소에 접근
# print(a3[1:4])  # [2, 3, 4] : a3[4]는 제외하고 접근함
# print(a3[-4:-1])  # [6, 7, 8] : a3[-1]는 제외하고 접근함


# 리스트 컴프리헨션: 대괄호에 조건문, 반복문을 넣어 리스트를 초기화
# 1차원
# arr = [i for i in range(20) if i%2 == 1]
# print(arr)  # [1, 3, 5, 7, 9, 11, 13, 15, 17, 19] : 홀수만 리스트에 넣기
# arr1 = [i**2 for i in range(9)]
# print(arr1)  # [0, 1, 4, 9, 16, 25, 36, 49, 64] : 1부터 9까지의 수의 제곱 값을 포함하는 리스트 : for문 앞에 식 쓰는 것임을 주의

# 2차원(matrix)
# n=3
# m=4
# mtx = [[0] * m for _ in range(n)]  # 가로(열)부터 값 채워지고, 세로(행)에 값 채워짐
# print(mtx)  # [[0, 0, 0, 0], [0, 0, 0, 0], [0, 0, 0, 0]]: 2차원 배열(매트릭스) 초기화 -> (3,4)
# mtx1 = [[0]*m]*n
# mtx1[1][1] = 5
# print(mtx1)  # [[0, 5, 0, 0], [0, 5, 0, 0], [0, 5, 0, 0]] : 잘못된 2차원 배열 초기화 -> 행의 자리 [1]을 모든 행에 적용
# mtx[1][1] = 5
# print(mtx)  # [[0, 0, 0, 0], [0, 5, 0, 0], [0, 0, 0, 0]]
# for _ in range(10):
#     print("Hello World!")  # Hello World! 10번 반복 : 언더바는 변수 값 상관없이 어떤 동작하려고 할 때 사용


# 리스트 관련 기타 메소드
# a4 = [1, 4, 3]
# print("기본 리스트: ", a4)  # 기본 리스트:  [1, 4, 3]

# 삽입
# a4.append(2)
# print(a4)  # [1, 4, 3, 2] : a4 마지막 위치에 원소 삽입
# a4.insert(1, "a")
# # [1, 'a', 4, 3, 2] : 특정 위치에 원소 삽입, type 다른 원소도 삽입 가능 : 그러나 type 다른 경우 정렬은 불가함에 주의
# print(a4)
# a4.remove('a')

# 정렬
# a4.sort()
# print("오름차순 정렬: ", a4)  # [1, 2, 3, 4]
# a4.sort(reverse=True)
# print("내림차순 정렬: ", a4)  # [4, 3, 2, 1]
# a4.reverse()
# print("거꾸로 정렬: ", a4)  # [1, 2, 3, 4]

# 제거
# a4.remove(1)
# print("특정한 값 제거한 결과: ", a4)  # [2, 3, 4]
# for i in range(3):
#     a4.append(5)
# print(a4)
# remove_set = {5}
# result = [i for i in a4 if i not in remove_set]
# print(result)  # [2, 3, 4] : 특정한 값 모두 제거 : 제거할 또는 제거하지 않을 배열 먼저 정하기


# 문자열 자료형
# 초기화
# a5 = "Hello I'm merry"
# print(a5)  # Hello I'm merry : 큰 따옴표 안에 작은 따옴표 사용 가능
# a6 = "Don't you know \"Python\"?"
# print(a6)  # Don't you know "Python"? : 그러나 백슬래쉬를 이용하면 큰따옴표 안에 큰따옴표 포함 가능

# 연산
# a7 = "Hello"
# b7 = "World"
# print(a7 + " " + b7)  # Hello World : 단순 문자열 연결
# print(a7 * 3)  # HelloHelloHello : 문자열이 양의 정수 개수만큼 여러 번 더해짐
# print(a7[3])  # l : 파이썬의 문자열은 리스트와 같이 처리됨, 따라서 인덱싱 가능


# 튜플 자료형: 리스트와 형태 유사
# a8 = (1, 2, 3, 4)
# print(a8)  # (1, 2, 3, 4)
# a8[2] = 7  # TypeError: 'tuple' object does not support item assignment : 튜플은 한 번 선언된 값을 변경할 수 없음


# 사전 자료형: 키와 값의 쌍을 가짐
# 초기화, 값 할당
# a9 = dict()
# a9['사과'] = 'Apple'
# a9['바나나'] = 'Banana'
# a9['코코넛'] = 'Coconut'
# print(a9)  # {'사과': 'Apple', '바나나': 'Banana', '코코넛': 'Coconut'}
# if '사과' in a9:
#     print("'사과'를 키로 가지는 데이터가 존재합니다!")

# 관련 함수
# key = a9.keys()
# val = a9.values()
# print(key)  # dict_keys(['사과', '바나나', '코코넛']) : 키만 뽑아서 리스트로 저장
# print(val)  # dict_values(['Apple', 'Banana', 'Coconut']) : 값만 뽑아서 리스트로 저장
# for i in key:
#     print(a9[i])  # Apple Banana Coconut


# 집합 자료형: 리스트 또는 문자열 이용해 만듦; 중복 불가, 순서 없음(=인덱싱 불가)
# 초기화
# a10 = set([1, 1, 2, 3, 4, 4, 5])
# print(a10)  # {1, 2, 3, 4, 5}: 중복 불가
# a11 = {1, 1, 2, 3, 4, 4, 5}
# print(a11)  # {1, 2, 3, 4, 5}
# a12 = {6, 7, 8}
# print(a10[2])  # TypeError: 'set' object is not subscriptable : 순서가 없으므로 인덱싱 불가

# 연산
# print(a10 | a12)  # {1, 2, 3, 4, 5, 6, 7, 8} : 합집합
# print(a10 & a12)  # set() : 교집합
# print(a10-a12)  # {1, 2, 3, 4, 5} : 차집합

# 관련 함수
# a10.add('a')
# # {1, 2, 3, 4, 5, 'a'} : 집합의 다른 원소와 type이 달라도 원소 추가 가능 : 그러나 "Literal['a']"이(가) "int"과(와) 호환되지 않습니다. warning 발생, 해결하려면 type: ignore 필요
# print(a10)
# a10.update([5, 6])
# print(a10)  # {1, 2, 3, 4, 5, 6, 'a'} : 새로운 원소 여러개 추가
# a10.remove(4)
# print(a10)  # {1, 2, 3, 5, 6, 'a'} : 특정한 값을 갖는 원소 제거
