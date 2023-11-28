while True:
    try:
        A, B, C = map(int, input().split())
        jumpA = B - A - 1
        jumpB = C - B - 1
        ans = max(jumpA, jumpB)
        if ans == 0:
            print(0)
        else:
            print(ans)
    except EOFError:
        break
