import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day6
{
    String[] questions;

    public Day6(String filename) {
        try {
            ArrayList<String> elements = new ArrayList<>();
            File file = new File(filename);
            Scanner scan = new Scanner(file);
            StringBuilder group = new StringBuilder("");
            String curLine;
            while (scan.hasNext()) {
                curLine = scan.nextLine();
                if (!curLine.equals("")) {
                    group.append(curLine);
                }
                else {
                    elements.add(group.toString());
                    group.delete(0, group.length());
                }
            }
            elements.add(group.toString());
            group.delete(0, group.length());
            questions = new String[elements.size()];
            questions = elements.toArray(new String[0]);
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    public void makeCharsUnique() {
        for (int j = 0; j < questions.length; j++) {
            String question = questions[j];
            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < question.length(); i++) {
                if (sb.indexOf(String.valueOf(question.charAt(i))) == -1) {
                    sb.append(String.valueOf(question.charAt(i)));
                }
            }
            questions[j] = sb.toString();
        }
    }

    public void printCount() {
        int totalcount=0;
        for (int j = 0; j < questions.length; j++) {
            totalcount += questions[j].length();
        }
        System.out.println(totalcount);
    }

    ArrayList<String[]> questionsPart2 = new ArrayList<>();

    public void part2(String filename) {
        try {
            ArrayList<String> elements = new ArrayList<>();
            File file = new File(filename);
            Scanner scan = new Scanner(file);
            StringBuilder group = new StringBuilder("");
            String curLine;
            while (scan.hasNext()) {
                curLine = scan.nextLine();
                if (!curLine.equals("")) {
                    group.append(curLine);
                    group.append(" ");
                }
                else {
                    questionsPart2.add(group.toString().split(" "));
                    group.delete(0, group.length());
                }
            }
            questionsPart2.add(group.toString().split(" "));
            group.delete(0, group.length());

        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    public void part2Answer() {
        Map<Character, Integer> charCount;
        int totalAnswered = 0;
        for (String[] curGroup : questionsPart2) {
            charCount = new HashMap<>();
            int size = curGroup.length;

            for (String person : curGroup) {
                for (int i = 0; i < person.length(); i++){
                    if (!charCount.containsKey(person.charAt(i))) {
                        charCount.put(person.charAt(i), 1);
                    }
                    else {
                        int c = charCount.get(person.charAt(i));
                        charCount.put(person.charAt(i), ++c);
                    }
                }
            }
            for (Character c : charCount.keySet()) {
                if (charCount.get(c) == size) {
                    totalAnswered++;
                }
            }
        }
        System.out.println(totalAnswered);
    }

    public static void main(String[] args) {
        String filename = "day6input.txt";
        Day6 day6 = new Day6(filename);
        day6.makeCharsUnique();
        day6.printCount();
        day6.part2(filename);
        day6.part2Answer();
    }
}