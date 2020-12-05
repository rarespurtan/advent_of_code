import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day4
{
    static final int REQUIRED_FIELDS = 8;
    static final String ALLOWED_MISSING = "cid";

    ArrayList<String[]> elements = new ArrayList<>();

    public Day4(String filename)
    {
        try
        {
            File file = new File(filename);
            Scanner scan = new Scanner(file);
            StringBuilder cur = new StringBuilder("");
            String a;
            while (scan.hasNext())
            {
                a = scan.nextLine();
                if (!a.equals(""))
                {
                    cur.append(a);
                    cur.append(" ");
                }
                else
                {
                    elements.add(cur.toString().split(" "));
                    cur.delete(0, cur.length());
                }
            }
            elements.add(cur.toString().split(" "));
            cur.delete(0, cur.length());

        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found");
        }
    }

    public void checkPassport()
    {
        int validPassportCount=0;
        for (String[] str : elements)
        {
            if (str.length <= 6) continue;
            if (str.length == 7)
            {
                boolean valid = true;
                for (String s : str)
                {
                    String[] temp = s.split(":");
                    if (temp[0].equals("cid")) valid = false;
                }
                if (valid) validPassportCount++;
            }
            else
            {
                validPassportCount++;
            }
        }
        System.out.println(validPassportCount);
    }
    public static void main(String[] args)
    {
        Day4 day4 = new Day4("day4input.txt");
        day4.checkPassport();
    }
}
