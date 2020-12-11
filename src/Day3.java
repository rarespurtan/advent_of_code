import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Day3
{
    private ArrayList<String> elements = new ArrayList<>();

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
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found");
        }
    }

    public int getTreeCount(int rowIncrement, int colIncrement)
    {
        int col=0;
        int treeCount=0;
        for (int row = 0; row < elements.size(); row+=rowIncrement)
        {
            if (elements.get(row).charAt(col % elements.get(0).length()) == '#') treeCount++;
            col += colIncrement;
        }
        return treeCount;
    }

    public static void main(String[] args)
    {
        Day3 day3 = new Day3("day3input.txt");
        int test1 = day3.getTreeCount(1, 1);
        int test2 = day3.getTreeCount(1, 3);
        int test3 = day3.getTreeCount(1, 5);
        int test4 = day3.getTreeCount(1, 7);
        int test5 = day3.getTreeCount(2, 1);
        System.out.println(test1 * test2 * test3 * test4 * test5);
    }
}
