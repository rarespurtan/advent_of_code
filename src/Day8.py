f = open("input/day8input.txt", "r")
lines = f.readlines()

def run_cmd(line, acc , j):
    cmd, num = line[0], line[1]
    if cmd == "acc":
        acc += int(num)
        j += 1
    elif cmd == "jmp":
        j += int(num)
    elif cmd == "nop":
        j+=1
    return acc, j     


def part1():
    
    bool_ = [False for i in lines]
    acc=0
    i = 0

    while (i < len(lines)):
        if bool_[i]:
            print(f'Repeated operation part 1 : {acc}')
            break
        line_ = lines[i].strip().split(" ")
        bool_[i] = True    
        acc, i = run_cmd(line_, acc, i)

def part2():
    for i in range(len(lines)):
        m_lines = list(lines)
        j = m_lines[i]
        if m_lines[i].split()[0] == 'nop':
            m_lines[i] = 'jmp '+ m_lines[i].split()[1]
        elif m_lines[i].split()[0] == 'jmp':
            m_lines[i] = 'nop ' + m_lines[i].split()[1]
        else:
            continue  
        terminate = 0
        acc=0
        j = 0
        while 0<=j<len(m_lines) and terminate<1000:

            terminate += 1
            line_ = m_lines[j].split()
            acc, j = run_cmd(line_, acc, j)

        if (j == len(lines)):
            print(f'Part 2 : {acc}')
            break

if __name__ == '__main__':
    part1()
    part2()