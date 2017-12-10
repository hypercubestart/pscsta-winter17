import java.io.File;
import java.util.Scanner;

public class SpaceRace {
    public static void main(String[] args) throws Exception {
        String testPath = "spacerace.in";
        String judgePath = "/Volumes/NO NAME/judge data/spacerace.in";

        Scanner in = new Scanner(new File(judgePath));
        int numCases = Integer.parseInt(in.nextLine());

        String shortestName = "";
        double shortest = Double.MAX_VALUE;
        for (int i = 0; i < numCases; i++) {
            String[] arr = in.nextLine().split(" ");
            double time = Double.parseDouble(arr[1]);
            time += Double.parseDouble(arr[2]) / Double.parseDouble(arr[3]);
            if (time < shortest) {
                shortest = time;
                shortestName = arr[0];
            }
        }
        System.out.println(shortestName + " finished in " + shortest + " seconds");
    }
}
