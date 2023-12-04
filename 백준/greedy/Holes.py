H = int(input())
if H == 0:
    print(1, end="")
if H != 0 and H % 2 == 0:
    for i in range(H // 2):
        print(8, end="")
elif H % 2 == 1:
    for i in range(H // 2 + 1):
        if H == 1:
            print(0, end="")
            break
        if i == 0:
            print(4, end="")
        else:
            print(8, end="")
