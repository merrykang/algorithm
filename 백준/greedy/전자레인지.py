"""
¼ôÄÚµù
 - https://claude-u.tistory.com/235
"""
T = int(input())
A = 60 * 5
B = 60 * 1
C = 10
a = 0
b = 0
c = 0

if T == 0:
    print("0")
if T % C != 0:
    print("-1")
while T % C == 0:
    if T >= A:
        a += int(T / A)
        T -= int(T / A) * A
    elif T >= B and T < A:
        b += int(T / B)
        T -= int(T / B) * B
    elif T >= C and T < B:
        c += int(T / C)
        T -= int(T / C) * C
    elif T == 0:
        print(a, b, c)
        break
