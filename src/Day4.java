import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day4
{
    ArrayList<String[]> elements = new ArrayList<>();

    public Day4(String filename)
    {
        try
        {
            File file = new File(filename);
            Scanner scan = new Scanner(file);
            StringBuilder curPassport = new StringBuilder("");
            String curLine;
            while (scan.hasNext())
            {
                curLine = scan.nextLine();
                if (!curLine.equals(""))
                {
                    curPassport.append(curLine);
                    curPassport.append(" ");
                }
                else
                {
                    elements.add(curPassport.toString().split(" "));
                    curPassport.delete(0, curPassport.length());
                }
            }
            elements.add(curPassport.toString().split(" "));
            curPassport.delete(0, curPassport.length());

        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found");
        }
    }
    public void part1()
    {
        int validPassportCount=0;
        for (String[] str : elements)
        {
            if (!isValid(str))
                continue;
            else
                validPassportCount++;
        }
        System.out.println(validPassportCount);
    }

    public void part2()
    {
        int validPassportCount = 0;
        for (String[] passport : elements)
        {
            if (!isValid(passport))
            {
                continue;
            }
            if (!checkData(passport))
            {
                continue;
            }

            validPassportCount++;
        }
        System.out.println(validPassportCount);
    }

    public boolean checkData(String[] passport)
    {
        for (String pass : passport)
        {
            String[] curData = pass.split(":");
            if (curData[0].equals("byr"))
            {
                if (!birthDay(curData[1])) return false;
            }
            if (curData[0].equals("iyr"))
            {
                if (!issueYear(curData[1])) return false;
            }
            if (curData[0].equals("eyr"))
            {
                if (!expirationYear(curData[1])) return false;
            }
            if (curData[0].equals("hgt"))
            {
                if (!height(curData[1])) return false;
            }
            if (curData[0].equals("hcl"))
            {
                if (!hairColor(curData[1]))
                    return false;
            }
            if (curData[0].equals("ecl"))
            {
                if (!eyeColor(curData[1]))
                    return false;
            }
            if (curData[0].equals("pid"))
            {
                if (!passportID(curData[1])) return false;
            }
        }
        return true;
    }

    public boolean birthDay(String str)
    {
        if (str.length() != 4) return false;
        if (Integer.parseInt(str) < 1920 || Integer.parseInt(str) > 2002) return false;
        return true;
    }

    public boolean issueYear(String str)
    {
        if (str.length() != 4) return false;
        if (Integer.parseInt(str) < 2010 || Integer.parseInt(str) > 2020) return false;
        return true;
    }

    public boolean expirationYear(String str)
    {
        if (str.length() != 4) return false;
        if (Integer.parseInt(str) < 2020 || Integer.parseInt(str) > 2030) return false;
        return true;
    }

    public boolean hairColor(String str)
    {
        if (str.charAt(0) != '#') return false;
        if (str.length() != 7) return false;
        ArrayList<Character> allowed = new ArrayList<>();
        allowed.add('0');
        allowed.add('1');
        allowed.add('2');
        allowed.add('3');
        allowed.add('4');
        allowed.add('5');
        allowed.add('6');
        allowed.add('7');
        allowed.add('8');
        allowed.add('9');
        allowed.add('a');
        allowed.add('b');
        allowed.add('c');
        allowed.add('d');
        allowed.add('e');
        allowed.add('f');

        for (int i = 1; i < str.length(); i++ )
        {
            if (!allowed.contains(str.charAt(i))) return false;
        }
        return true;
    }


    public boolean eyeColor(String str)
    {
        if (str.length() != 3) return false;
        ArrayList<String> allowed = new ArrayList<>();
        allowed.add("amb");
        allowed.add("blu");
        allowed.add("brn");
        allowed.add("gry");
        allowed.add("grn");
        allowed.add("hzl");
        allowed.add("oth");

        if (!allowed.contains(str)) return false;

        return true;
    }

    public boolean passportID(String str)
    {
        if (str.length() != 9) return false;
        try
        {
            int n = Integer.parseInt(str);
            return true;
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }

    public boolean height(String str)
    {
        if (str.length() < 4) return false;
        int number = Integer.parseInt(str.substring(0, str.length()-2));
        String metric = str.substring(str.length()-2, str.length());
        if (metric.equals("cm"))
        {
            if (number < 150 || number > 193) return false;
        }
        else
        {
            if (number < 59 || number > 76) return false;
        }
        return true;
    }

    public boolean isValid(String[] passport) {
        if (passport.length <= 6) return false;
        if (passport.length == 7)
        {
            for (String s : passport)
            {
                String[] temp = s.split(":");
                if (temp[0].equals("cid")) return false;
            }
        }
        return true;
    }

    public static void main(String[] args)
    {
        Day4 day4 = new Day4("day4input.txt");
        day4.part1();
        day4.part2();
    }
}
