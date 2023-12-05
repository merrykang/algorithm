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