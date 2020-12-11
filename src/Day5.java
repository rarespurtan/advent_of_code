import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day5
{
    private String[] paths;
    private final int ROW = 128;
    private final int COLUMN = 8;
    private int[][] plane = new int[ROW][COLUMN];


    public Day5(String filename)
    {
        ArrayList<String> temp = new ArrayList<>();
        File file = new File(filename);
        try
        {
            Scanner scan = new Scanner(file);
            while (scan.hasNext())
            {
                temp.add(scan.nextLine());
            }
            paths = new String[temp.size()];
            paths = temp.toArray(new String[0]);
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Could not find file");
        }
    }

    public static void main(String[] args)
    {
        Day5 day5 = new Day5("day5input.txt");
    }
}
