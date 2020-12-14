import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day5{
    String[] paths;
    int[] seats;
    ArrayList<Character> one = new ArrayList<>();

    public Day5(String filename) {
        ArrayList<String> temp = new ArrayList<>();
        File file = new File(filename);
        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNext()) {
                temp.add(scan.nextLine());
            }
            paths = new String[temp.size()];
            paths = temp.toArray(new String[0]);
            seats = new int[paths.length];
            one.add('R');
            one.add('B');
        }
        catch (FileNotFoundException e) {
            System.out.println("Could not find file");
        }
    }

    public void setSeats() {
        for (int i = 0; i < paths.length; i++) {
            StringBuilder sb = new StringBuilder();
            String rowConfig = paths[i].substring(0,7);
            String colConfig = paths[i].substring(7);
            checkIfExists(sb, rowConfig);
            int rowNumber = Integer.parseInt(sb.toString(), 2);

            sb = new StringBuilder();

            checkIfExists(sb, colConfig);

            int colNumber = Integer.parseInt(sb.toString(), 2);

            seats[i] = rowNumber*8+colNumber;
        }
    }

    private void checkIfExists(StringBuilder sb, String str) {
        for (int j = 0; j < str.length(); j++) {
            if (one.contains(str.charAt(j))) {
                sb.append("1");
            }
            else {
                sb.append("0");
            }
        }
    }

    private void printHighest() {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < seats.length; i++) {
            if (max < seats[i]) max = seats[i];
        }
        System.out.println("Highest seat number: " + max);
    }

    private void printMySeat() {
        Arrays.sort(seats);
        int mySeat = seats[0];
        for (int i = 1; i < seats.length-1; i++) {
            if (seats[i-1] != seats[i]-1) {
                mySeat = seats[i]-1;
            }
        }
        System.out.println("My seat is :" + mySeat);
    }

    public static void main(String[] args) {
        Day5 day5 = new Day5("day5input.txt");
        day5.setSeats();
        day5.printHighest();
        day5.printMySeat();
    }
}