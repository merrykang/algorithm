A, B = map(str, input().split())  # int가 아니라 map 함수 써야함
arrA = [str(i) for i in A]  # 문자열의 각 자릿수를 쪼개서 배열로 변환
arrB = [str(j) for j in B]
minA = maxA = minB = maxB = ""


def computeMin(arr):
    for i in range(len(arr)):
        if arr[i] == "6":
            arr[i] = "5"
    if arr == arrA:
        minA = "".join(arrA)
        return int(minA)
    elif arr == arrB:
        minB = "".join(arrB)
        return int(minB)


def computeMax(arr):
    for i in range(len(arr)):
        if arr[i] == "5":
            arr[i] = "6"
    if arr == arrA:
        maxA = "".join(arrA)
        return int(maxA)
    elif arr == arrB:
        maxB = "".join(arrB)
        return int(maxB)


print(computeMin(arrA) + computeMin(arrB), computeMax(arrA) + computeMax(arrB))

# for i in range(2):
#     if A[i] == "1":
#         A[i] = "2"
#     print(A)
# A.replace("11", "22", 1000000)
# print(A)

# def computeMin(string):
#     for i in range(len(string)):
#         print(string[i])
#         if string[i] == 6:
#             string.replace(i, 5)  # string의 replace를 숫자로 해서 틀림 / replace는 for문 사용하지 않아도 됨
#         return int(string)


# def computeMax(string):
#     # for j in string:
#     #     string.
#     #     print(j)
#     #     if j == 5:
#     string.replace("5", "6")
#     return int(string)


# mini = computeMin(A) + computeMin(B)
# maxi = computeMax(A) + computeMax(B)
# print(mini, maxi)
