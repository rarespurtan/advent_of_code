import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;


// linkedlist -> Node(bag A can hold B and C)
// map "bagname" -> Node


public class Day7{
    class Node {
        String bagName;
        ArrayList<String> bags;
        Node(String bagName, ArrayList<String> bags) {
            this.bagName = bagName;
            this.bags = bags;
        }
    }


    private ArrayList<String> lines = new ArrayList<>();

    public Day7(String filename) {
        try {
            File file = new File(filename);
            Scanner scan = new Scanner(file);
            while (scan.hasNext()) {
                lines.add(scan.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Day7 day7 = new Day7("day7input.txt");
    }
}
