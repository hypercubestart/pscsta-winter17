import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class Fezr {
    public static void main(String[] args) throws Exception {
        String testPath = "fezr.in";
        String judgePath = "/Volumes/NO NAME/judge data/fezr.in";

        Scanner in = new Scanner(new File(judgePath));
        int numCases = Integer.parseInt(in.nextLine());

        for (int i = 0; i < numCases; i++) {
            HashMap<Integer, Boolean> map = new HashMap<>();
            for (int j = 0; j <= 5000; j++) {
                map.put(j, false);
            }
            int numIntervals = Integer.parseInt(in.nextLine());
            for (int j = 0; j < numIntervals; j++) {
                String[] arrInterval = in.nextLine().split(" ");
                for (int k = Integer.parseInt(arrInterval[0]); k <= Integer.parseInt(arrInterval[1]); k++) {
                    map.put(k, true);
                }
            }
            int counter = 0;
            for (int j = 0; j <= 5000; j++) {
                if (map.get(j)) counter++;
            }
            System.out.println(counter);
        }
    }
}
