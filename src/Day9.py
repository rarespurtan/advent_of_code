import itertools

f = open("input/day9input.txt", "r")
lines = [int(l.strip()) for l in f.readlines()]

GOAL = 0

def part1():
    AIM = 25
    for i in range(AIM, len(lines)):
        ok = True
        prev = lines[i-AIM:i]
        assert len(prev) == 25
        for j,k in itertools.combinations(prev,2):
            if j+k == lines[i]:
                ok = False
        if ok:
            global GOAL
            GOAL=lines[i]
            break    

def part2():
    m_lines = list(lines)
    for i in range(len(m_lines)):
        m_sum = m_lines[i]
        m_min = m_lines[i]
        m_max = m_lines[i]
        for j in range(i+1, len(lines)):
            m_sum += lines[j]
            m_min = min(lines[j], m_min)
            m_max = max(lines[j], m_max)
            if m_sum == GOAL:
                print(m_min + m_max)
                        
if __name__ == '__main__':
    part1()
    part2()