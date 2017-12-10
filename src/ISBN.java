import java.io.File;
import java.util.Scanner;

public class ISBN {
    public static void main(String[] args) throws Exception {
        String testPath = "isbn.in";
        String judgePath = "/Volumes/NO NAME/judge data/isbn.in";

        Scanner in = new Scanner(new File(judgePath));
        int numCases = Integer.parseInt(in.nextLine());

        for (int i = 0; i < numCases; i++) {
            String isbn = in.nextLine();
            int sum = 0;
            for (int j = 0; j < isbn.length(); j++) {
                if (j % 2 == 0) {
                    sum += Character.getNumericValue(isbn.charAt(j));
                } else {
                    sum += 3 * Character.getNumericValue(isbn.charAt(j));
                }
            }
            if (sum % 10 == 0) System.out.println("VALID");
            else System.out.println("INVALID");
        }
    }
}
