import java.io.File;
import java.util.Scanner;

public class Practice {
    public static void main(String[] args) throws Exception {
        String testPath = "practice.dat";
        String judgePath = "/Volumes/PSCSTA/judgesdata/goteam.in";

        Scanner in = new Scanner(new File(judgePath));
        int numCases = in.nextInt();

        in.nextLine();

        for (int i = 0; i < numCases; i++) {
            System.out.println("Go " + in.nextLine() + "!");
        }
    }
}