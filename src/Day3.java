import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Day3
{
    ArrayList<String> elements = new ArrayList<>();

    public Day3(String filename)
    {
        try
        {
            File file = new File(filename);
            Scanner scan = new Scanner(file);
            int j=0;
            while (scan.hasNext())
            {
                String cur = scan.nextLine();
                elements.add(cur);
                System.out.println(cur);
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found");
        }
    }

    public void getTreeCount()
    {
        int col=0;
        int treeCount=0;
        for (int row = 0; row < elements.size(); row++)
        {
            if (elements.get(row).charAt(col % elements.get(0).length()) == '#') treeCount++;
            col += 3;
        }
        System.out.println(treeCount);
    }

    public static void main(String[] args)
    {
        Day3 day3 = new Day3("day3input.txt");
        day3.getTreeCount();
    }
}
