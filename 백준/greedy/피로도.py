A, B, C, M = map(int, input().split())
work = time = tired = 0
timeA = int(M / A)
timeC = int(M / C)
# while time <= 24:
#     work += B * int(M / A)
#     time += int(M / A) + int(M / C)
#     tired = A * int(M / A) - C * int(C / A)
#     if (time + int(M / A) + int(C / A)) > 24:
#         break

# while time <= 24:
#     if tired >= M or A > M:
#         break
#     if (time + timeA + timeC) <= 24:
#         work += B * timeA
#         time += timeA + timeC
#         tired = A * timeA - C * timeC
#         if tired < 0:
#             tired = 0
#     elif (time + timeA + timeC) > 24:
#         # if tired + A > M:
#         #     break
#         work += B
#         tired += A

while time <= 24:
    if M < A:
        break
    else:
        if tired >= M or (time + timeA) > 24:
            break
        elif tired < 0:
            tired = 0
        else:
            work += B * timeA
            tired = A * timeA - C * timeC
            time += timeA + timeC

print(work)
