import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day6
{
    String[] questions;

    public Day6(String filename)
    {
        try
        {
            ArrayList<String> elements = new ArrayList<>();
            File file = new File(filename);
            Scanner scan = new Scanner(file);
            StringBuilder group = new StringBuilder("");
            String curLine;
            while (scan.hasNext())
            {
                curLine = scan.nextLine();
                if (!curLine.equals(""))
                {
                    group.append(curLine);
                }
                else
                {
                    elements.add(group.toString());
                    group.delete(0, group.length());
                }
            }
            elements.add(group.toString());
            group.delete(0, group.length());
            questions = new String[elements.size()];
            questions = elements.toArray(new String[0]);
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found");
        }
    }

    public void makeCharsUnique()
    {
        for (int j = 0; j < questions.length; j++)
        {
            String question = questions[j];
            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < question.length(); i++)
            {
                if (sb.indexOf(String.valueOf(question.charAt(i))) == -1)
                {
                    sb.append(String.valueOf(question.charAt(i)));
                }
            }
            questions[j] = sb.toString();
        }
    }

    public void printCount()
    {
        int totalcount=0;
        for (int j = 0; j < questions.length; j++)
        {
            totalcount += questions[j].length();
        }
        System.out.println(totalcount);
    }

    public static void main(String[] args)
    {
        Day6 day6 = new Day6("day6input.txt");
        day6.makeCharsUnique();
        day6.printCount();
    }

}
