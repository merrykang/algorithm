# 함수(function)
# 개요: return 문 있, 없 비교
# print("=============== return 문 있음 ================")


# def add(a, b):
#     return a+b


# print(add(3, 7))  # 10
# print("=============== return 문 없음 ================")


# def add1(a, b):
#     print("함수의 결과: ", a+b)


# add1(3, 8)  # 11


# 파라미터 값 지정하여 함수에 넘기기
# add1(b=9, a=11)  # 20 : 파라미터 변수를 정확하게 지정할 때는 순서 상관없음

# global 키워드 : 함수 안(local)에서 함수 밖(global)의 변수 데이터를 변경하는 경우
# a = 0


# def func():
#     global a
#     a += 1


# for i in range(10):
#     func()
# print(a)  # 20 : 0부터 9까지 9번 호출된 것임

# lambda express(람다 표현식) : 특정 기능을 수행하는 함수를 한 줄에 작성 가능 : 일반적으로 간단한 기능 구현할 때 사용
# print("=============== 람다 표현식 ================")
# print((lambda a, b: a+b)(3, 7))  # 10


# 입출력(input / output)
# input() : 아래 코드가 전형적인 형태
# n = int(input())  # 데이터의 개수 입력
# print(n)
# data = list(map(int, input().split()))
# data.sort(reverse=True)
# print(data)
# 입력 받는 자료 개수가 많지 않은 경우
# n, m, k = map(int, input().split())
# print(n, m, k)

# sys.stdin.readline().rstrip() : 입력 받는 자료 개수가 많은 경우
# import sys
# data = sys.stdin.readline().rstrip()
# print(data)

# print() : print() 사용할 때마다 줄바꿈됨 : 단순히 + 사용하여 문자열과 수 더하면 오류 발생
# ans = 7
# # type error: TypeError: can only concatenate str (not "int") to str
# # print("정답은" + ans + "입니다")
# print("정답은", ans, "입니다.")  # 정답은 7 입니다. : 해결1 콤마 사용, 공백 삽입됨에 주의
# print("정답은" + str(ans) + "입니다.")  # 정답은7입니다. : 해결2 str이 아닌 변수를 str로 변환
# # 정답은 7 입니다 : 해결3 f-string 문법, 파이썬 3.6 버전 이상에서만 사용 가능하므로 위 해결책으로 해결할 것
# print(f"정답은 {ans} 입니다.")
