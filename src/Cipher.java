import java.io.File;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cipher {
    public static void main(String[] args) throws Exception {
        String testPath = "cipher.in";
        String judgePath = "/Volumes/NO NAME/judge data/cipher.in";

        Scanner in = new Scanner(new File(judgePath));

        String input = in.nextLine();

        int numCases = Integer.parseInt(in.nextLine());

        for (int i = 0; i < numCases; i++) {
            String pattern = in.nextLine();

            System.out.println(getMatch(input, pattern));
        }
    }

    public static String getMatch(String input, String pattern) {
        for (int i = 0; i < input.length() - pattern.length() + 1; i++) {
            String inputInside = input.substring(i, i + pattern.length());
            if (compare(inputInside, pattern)) {

                return inputInside;
            }

        }
        return "-";
    }

    public static boolean compare(String s1, String s2) {
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            if (!map.containsKey(s1.charAt(i))) {
                if (map.containsValue(s2.charAt(i))) return false;
                map.put(s1.charAt(i), s2.charAt(i));

            } else {
                if (s2.charAt(i) != map.get(s1.charAt(i))) return false;
            }
        }
        return true;
    }

}
