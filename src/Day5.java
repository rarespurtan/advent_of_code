import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day5
{
    private String[] paths;
    private final int ROW = 128;
    private final int COLUMN = 8;
    private int[][] plane = new int[ROW][COLUMN];
    private Map<String, Integer[]> codeToSeat = new HashMap<>();

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

    public void decode()
    {
        for (String code : paths)
        {
            String rowConfig = code.substring(0,7);
            String colConfig = code.substring(7);
            int row = binarySpacePartitioning(rowConfig, 0 , 127, 'F');
            int col = binarySpacePartitioning(colConfig, 0 , 7, 'L');
            int seatID = seatID(row, col);
            codeToSeat.put(code, new Integer[]{row, col, seatID});
        }
    }

    public void printHighestSeat()
    {
        int max = Integer.MIN_VALUE;
        for (String str : codeToSeat.keySet())
        {
            if (codeToSeat.get(str)[2] > max)
            {
                max = codeToSeat.get(str)[2];
            }
        }
        System.out.println(max);
    }

    public int seatID(int row, int col)
    {
        return row*8+col;
    }

    public int binarySpacePartitioning(String rowConfig, int l, int r, char dir)
    {
        int mid = ((r + l)+1)/2;
        char c = rowConfig.charAt(0);
        if (rowConfig.length() == 1)
        {
            if (c == dir)
            {
                return l;
            }else
            {
                return r;
            }
        }
        else
        {
            if (c == dir)
            {
                return binarySpacePartitioning(rowConfig.substring(1), l, mid, dir);
            }
            else
            {
                return binarySpacePartitioning(rowConfig.substring(1), mid, r, dir);
            }
        }
    }

    public static void main(String[] args)
    {
        Day5 day5 = new Day5("day5input.txt");
        day5.decode();
        day5.printHighestSeat();
    }
}
