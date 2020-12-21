import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.*;


// linkedlist -> Node(bag A can hold B and C)
// map "bagname" -> Node


public class Day7{

    class Node {
        String bagName;
        ArrayList<String> childBag;
        Node(String bagName, ArrayList<String> bags) {
            this.bagName = bagName;
            this.childBag = bags;
        }
    }

    private Map<String, Node> bagToNode = new HashMap<>();

    public Day7(String filename) {
        try {
            File file = new File(filename);
            Scanner scan = new Scanner(file);
            String line, rootBag, childBag;
            int i;
            Node n;
            while (scan.hasNext()) {
                line = scan.nextLine();

                i = line.indexOf("bags");

                rootBag = line.substring(0,i-1);
                rootBag = rootBag.trim();

                childBag = line.substring(i);
                childBag = formatLine(childBag);

                ArrayList<String> arrN = getBagsFromChild(childBag);

                n = new Node(rootBag, arrN);

                if (!bagToNode.containsKey(rootBag)){
                    bagToNode.put(rootBag, n);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void part1() {
        int count = 0;
        for (String bag : bagToNode.keySet()) {

            ArrayList<String> arr = bagToNode.get(bag).childBag;

            Queue<String> queue = new LinkedList<>();
            boolean found = false;
            for (String b : arr) {
                if (b.equals("shiny gold")) {
                    count++;
                    break;
                } else {
                    Node n = bagToNode.get(b);
                    for (String t : n.childBag) {
                        if (b.equals("shiny gold")) {
                            count++;
                            found = true;
                            break;
                        }
                    }
                }
                if (found) continue;

            }
        }
        System.out.println(count);
    }

    public ArrayList<String> getBagsFromChild(String n){
        String [] a = n.split("\\s+");
        ArrayList<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int i;
        for (i = 0; i < a.length-1; i+=2) {
            if (a[i].equals("") || a[i+1].equals("")) continue;
            sb.append(a[i]);
            sb.append(" ");
            sb.append(a[i+1]);
            result.add(sb.toString());
            sb = new StringBuilder();
        }
        return result;
    }

    public String formatLine(String line){
        line = line.replaceAll("\\p{Punct}", "");
        line = line.replaceAll("bags","");
        line = line.replaceAll("bag","");
        line = line.replaceAll("[^A-Za-z ]","");
        line = line.replaceAll("contain","");
        line = line.trim();
        return line;
    }


    public static void main(String[] args) {
        Day7 day7 = new Day7("day7input.txt");
        day7.part1();
    }
}
