f = open("input/day8input.txt", "r")
lines = f.readlines()

def part1():
    
    bool_ = [False for i in lines]
    acc=0
    i = 0

    while (i < len(lines)):
        if bool_[i]:
            print(f'Repeated operation part 1 : {acc}')
            break
        line_ = lines[i].strip().split(" ")
        if line_[0] == "acc":
            acc += int(line_[1])
            bool_[i] = True
        elif line_[0] == "jmp":
                bool_[i] = True 
                i += int(line_[1])
                continue
        elif line_[0] == "nop":
                bool_[i] = True
                i+=1
                continue
        i += 1    

def part2():
    for i in range(len(lines)):
        temp_lines = list(lines)
        j = temp_lines[i]
        if temp_lines[i].split()[0] == 'nop':
            temp_lines[i] = 'jmp '+ temp_lines[i].split()[1]
        elif temp_lines[i].split()[0] == 'jmp':
            temp_lines[i] = 'nop ' + temp_lines[i].split()[1]
        else:
            continue  
        terminate = 0
        acc=0
        j = 0
        while 0<=j<len(temp_lines) and terminate<1000:

            terminate += 1
            line_ = temp_lines[j].split()
            cmd, num = line_[0], line_[1]

            if cmd == "acc":
                acc += int(num)
                j += 1
            elif cmd == "jmp":
                    j += int(num)
            elif cmd == "nop":
                    j+=1
                    
        if (j == len(lines)):
            print(acc)    

if __name__ == '__main__':
    part1()
    part2()