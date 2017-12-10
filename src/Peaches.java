import java.io.File;
import java.util.Scanner;

public class Peaches {
    public static void main(String[] args) throws Exception {
        String testPath = "peaches.in";
        String judgePath = "/Volumes/NO NAME/judge data/peaches.in";

        Scanner in = new Scanner(new File(judgePath));
        int numCases = Integer.parseInt(in.nextLine());

        for (int i = 0; i < numCases; i++) {
            String[] arr = in.nextLine().split(" ");
            int numPeaches = Integer.parseInt(arr[0]);
            int c = Integer.parseInt(arr[1]);
            int r = Integer.parseInt(arr[2]);
            int p = Integer.parseInt(arr[3]);

            int fromC = 0, fromR = 0, fromP = 0;
            int cost = 0;
            while (numPeaches > 0) {
                if (c > 0) {
                    fromC++;
                    numPeaches--;
                    c--;
                    cost++;
                    continue;
                }
                if (r > 0) {
                    fromR++;
                    numPeaches--;
                    r--;
                    cost += 2;
                    continue;
                }
                if (p > 0) {
                    fromP++;
                    numPeaches--;
                    p--;
                    cost += 3;
                    continue;
                }
            }
            System.out.println(fromC + " " + fromR + " " + fromP + " $" + cost);
        }
    }
}
