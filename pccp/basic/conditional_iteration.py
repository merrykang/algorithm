# 조건문(conditional)
# 개요: if 문 사용 : elif 에 주의
# score = 85
# if score >= 80:
#     print("학점: A")
# elif score >= 70:
#     print("학점: B")
# else:
#     print("학점: C")  # 실행 결과 : 학점: A
# 실행 결과 : 프로그램을 종료합니다! : 조건문 실행과 관계없이 무조건 실행 (case 문의 default와 유사)
# print("프로그램을 종료합니다!")

# 기타 연산자 : in, not in, pass
# print('=========================')
# if score >= 80:
#     pass
# else:
#     print("성적이 80점 미만입니다!")
# print('프로그램을 종료합니다!')  # 실행 결과 : 프로그램을 종료합니다! : pass되어 아무 것도 실행되지 않아 이러한 결과가 출력됨

# 팁: 한 줄 작성, 부등식 2개 한 번에 사용
# print('=========== 한 줄 작성 ==============')
# if score >= 80:
#     result = 'success'
# else:
#     result = 'fail'
# print(result)  # 실행 결과 : success : 원래 한 줄 작성되는데 지금은 vscode 자동 형식 검사 때문에 줄 바꿈 됨
# print('============ 조건부 표현식 =============')
# result = 'success girl~~!!!' if score >= 80 else 'fail'
# print(result)  # 실행 결과 : success girl~~!!!
# print('============ 부등식 2개 이상 사용 =============')
# x = 15
# if 0 < x < 20:
#     # 실행 결과 : x는 0 초과 20 미만의 수입니다! : 0<x<20 = 0<x and x<20
#     print("x는 0 초과 20 미만의 수입니다!")


# 반복문(iteration)
# while문
# i = 1
# result = 0
# while i <= 9:
#     result += i
#     i += 1
# print(result)  # 45 : 1부터 9까지의 합

# for문
# range()
result = 0
for i in range(1, 10):
    result += i
print(result)  # 45 : 1부터 9까지의 합
print('============ range()의 인수로 하나의 값만 넣으면 자동으로 시작 값이 0 =============')
scores = [90, 85, 77, 65, 97]
for i in range(5):
    if scores[i] >= 80:
        # 실행 결과 : 1 번 학생은 합격입니다! 2 번 학생은 합격입니다! 5 번 학생은 합격입니다!
        print(i+1, "번 학생은 합격입니다!")

# continue
print('============ continue =============')
cheating = {2, 4}
for i in range(5):
    if i+1 in cheating:
        continue
    if scores[i] >= 90:
        # 실행 결과 : 1 번 학생은 합격입니다! 5 번 학생은 합격입니다!
        print(i+1, "번 학생은 합격입니다!")

# 중첩 반복문
print('============ 중첩 반복문 =============')
for i in range(2, 10):
    for j in range(1, 10):
        print(i, "X", j, "=", i*j)  # 실행 결과: 2단부터 9단까지 구구단 출력
    print()  # i단끼리 줄바꿈 추가하기 위해 넣은 코드
