import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Day1 {

    ArrayList<Integer> elements = new ArrayList<>();
    final int SUM = 2020;

    public Day1(String filename)
    {
        try
        {
            File file = new File(filename);
            Scanner scan = new Scanner(file);
            while (scan.hasNext())
            {
                int cur = Integer.parseInt(scan.next());
                elements.add(cur);
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found");
        }
    }
    public void productOfTwo()
    {
        int product = -1;

        for (Integer cur : elements)
        {
            int complement = SUM - cur;
            if (elements.contains(complement))
            {
                product = cur * complement;
                break;
            }
        }
        if (product != -1) System.out.println(product);
        else System.out.println("Product not found");
    }

    public void productOfThree()
    {
        Collections.sort(elements);

        int product = -1;
        int leftPointer,rightPointer;

        for (int curPointer = 0; curPointer < elements.size() - 2; curPointer++)
        {
            leftPointer = curPointer + 1;
            rightPointer = elements.size() - 1;

            while (leftPointer < rightPointer)
            {
                if (elements.get(curPointer) + elements.get(leftPointer) + elements.get(rightPointer) == SUM)
                {
                    product = elements.get(curPointer) * elements.get(leftPointer) * elements.get(rightPointer);
                    break;
                }
                else if (elements.get(curPointer)  + elements.get(leftPointer)  + elements.get(rightPointer) < SUM)
                    leftPointer++;
                else
                    rightPointer--;
            }
        }
        if (product != -1) System.out.println(product);
        else System.out.println("Product not found");
    }

    public static void main(String[] args)
    {
        Day1 day1 = new Day1("day1input.txt");
        day1.productOfTwo();
        day1.productOfThree();
    }
}
