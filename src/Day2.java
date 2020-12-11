import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day2
{
    private ArrayList<String> elements = new ArrayList<>();

    public Day2(String filename)
    {
        try
        {
            File file = new File(filename);
            Scanner scan = new Scanner(file);
            while (scan.hasNext())
            {
                String cur = scan.nextLine();
                elements.add(cur);
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found");
        }
    }

    public void validPasswords()
    {
        int validPasswordCountOldPolicy = 0;
        int validPasswordCountNewPolicy = 0;

        for (String curPass : elements)
        {
            String[] data = curPass.split(" "); // split into range, targetChar, password

            String[] range = data[0].split("-"); // split range into lower and upper bounds
            int lowerRange, upperRange;
            lowerRange = Integer.parseInt(range[0]);
            upperRange = Integer.parseInt(range[1]);

            String password = data[2];
            char targetChar = data[1].charAt(0); // target char

            int charCount = 0;

            for (int i = 0; i < password.length(); i++)
            {
                if (password.charAt(i) == targetChar)
                {
                    charCount++;
                }
            }

            if (charCount >= lowerRange && charCount <= upperRange)
            {
                validPasswordCountOldPolicy++;
            }

            try
            {
                if (password.charAt(lowerRange-1) == targetChar && password.charAt(upperRange-1) != targetChar)
                {
                    validPasswordCountNewPolicy++;
                }
                else if (password.charAt(lowerRange-1) != targetChar && password.charAt(upperRange-1) == targetChar)
                {
                    validPasswordCountNewPolicy++;
                }
            } catch (NumberFormatException e)
            {
                continue;
            }
        }

        System.out.println("Valid passwords using first policy: " + validPasswordCountOldPolicy);
        System.out.println("Valid passwords using new policy: " + validPasswordCountNewPolicy);

    }


    public static void main(String[] args) {
        Day2 day2 = new Day2("day2input.txt");
        day2.validPasswords();
    }
}
