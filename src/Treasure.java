import java.io.File;
import java.util.Scanner;

public class Treasure {
    public static void main(String[] args) throws Exception {
        String testPath = "treasure.in";
        String judgePath = "/Volumes/NO NAME/judge data/treasure.in";

        Scanner in = new Scanner(new File(judgePath));
        int numCases = Integer.parseInt(in.nextLine());

        for (int i = 0; i < numCases; i++) {
            String s = in.nextLine();
            if (s.length() != 6) {
                System.out.println("NO");
                continue;
            }
            if (s.charAt(0) != s.charAt(2)) {
                System.out.println("NO");
                continue;
            }
            if (Character.getNumericValue(s.charAt(1)) % 2 != 0) {
                System.out.println("NO");
                continue;
            }

            int num = Character.getNumericValue(s.charAt(3)) + Character.getNumericValue(s.charAt(4)) + Character.getNumericValue(s.charAt(5));
            if (num % 7 != 0) {
                System.out.println("NO");
                continue;
            }
            System.out.println("YES");
        }
    }
}
