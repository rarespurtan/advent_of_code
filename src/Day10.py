f = open("../input/day10input.txt", "r")
# f = open("testinput/day10test.txt", "r")
lines = [int(l.strip()) for l in f.readlines()]
lines.append(0)
lines = sorted(lines)
lines.append(max(lines) + 3)

one_diff = 0
three_diff = 0

for i in range(len(lines) - 1):
    delta = lines[i + 1] - lines[i]
    if delta == 1:
        one_diff += 1
    elif delta == 3:
        three_diff += 1

memo = {}


def dp(n):
    if n == len(lines) - 1:
        return 1
    if n in memo:
        return memo[n]
    ans = 0
    for j in range(n + 1, len(lines)):
        if lines[j] - lines[n] <= 3:
            ans += dp(j)
    memo[n] = ans
    return ans


print("part1", one_diff * three_diff)
print("part2", dp(0))
