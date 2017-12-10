import java.io.File;
import java.util.Scanner;

public class Pandora {
    public static void main(String[] args) throws Exception {
        String testPath = "pandora.in";
        String judgePath = "/Volumes/NO NAME/judge data/pandora.in";

        Scanner in = new Scanner(new File(judgePath));
        int numCases = Integer.parseInt(in.nextLine());

        for (int i = 0; i < numCases; i++) {
            String s = in.nextLine();
            String[] parts = s.split(" ");
            int birthYear = Integer.parseInt(parts[0]);
            int deathYear = Integer.parseInt(parts[1]);
            int counter = 0;
            for (int j = birthYear + 1; j<=deathYear; j++) {
                if (j >= 1500 && j%4==0) {
                    counter++;
                }
            }

            System.out.println(counter + " Games");
        }
    }
}
