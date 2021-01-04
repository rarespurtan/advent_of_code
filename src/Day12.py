f = open("../input/day12input.txt", "r")
# f = open("../testinput/day12test.txt", "r")
lines = [line.strip() for line in f.readlines()]
# nesw
dirX = [0, 1, 0, -1]
dirY = [1, 0, -1, 0]

x = 0
y = 0
angle = 1

for line in lines:
    n = int(line[1:])
    cmd = line[0]
    if cmd == "E":
        x += n
    elif cmd == "W":
        x -= n
    elif cmd == "S":
        y -= n
    elif cmd == "N":
        y += n
    elif cmd == "L":
        angle = (angle + 3 * (n // 90)) % 4
    elif cmd == "R":
        angle = (angle + 1 * (n // 90)) % 4
    elif cmd == "F":
        x += dirX[angle] * n
        y += dirY[angle] * n
    print(line, angle, x, y)

print(abs(x) + abs(y))
