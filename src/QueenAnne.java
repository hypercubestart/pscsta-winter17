import java.io.File;
import java.util.Scanner;

public class QueenAnne {
    public static void main(String[] args) throws Exception {
        String testPath = "queenanne.in";
        String judgePath = "/Volumes/NO NAME/judge data/queenanne.in";

        Scanner in = new Scanner(new File(judgePath));
        int numCases = Integer.parseInt(in.nextLine());

        for (int i = 0; i < numCases; i++) {
            String s = in.nextLine();
            boolean hasDouble = false;
            for (int j = 0; j < s.length() - 1; j++) {
                if (s.charAt(j) == s.charAt(j + 1)) {
                    hasDouble = true;
                    break;
                }
            }
            if (hasDouble) System.out.println("likes " + s);
            else System.out.println("hates " + s);
        }
    }
}
