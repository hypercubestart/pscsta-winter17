import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Phone {
    public static void main(String[] args) throws Exception {
        String testPath = "phone.in";
        String judgePath = "/Volumes/NO NAME/judge data/phone.in";

        Scanner in = new Scanner(new File(judgePath));
        String words = in.nextLine();

        String[] wordlist = words.split(" ");

        int numCases = Integer.parseInt(in.nextLine());

        for (int i = 0; i < numCases; i++) {
            String sequence = in.nextLine();
            int match = recursion(sequence, 0, "", wordlist);
            if (match == 1) {
                System.out.println(match + " match");
            } else {
                System.out.println(match + " matches");
            }
        }
    }

    public static int recursion(String number, int index, String sofar, String[] wordlist) {
        if (index == number.length()) {
            return beginsWith(sofar, wordlist);
        }
        int matches = 0;
        for (char c: charlist(number.charAt(index))) {
            matches += recursion(number, index+1,sofar+c, wordlist);
        }
        return matches;
    }

    public static int beginsWith(String sofar, String[] wordlist) {
        int counter = 0;
        for (String s: wordlist) {
            if (s.indexOf(sofar)==0) counter++;
        }
        return counter;
    }

    public static char[] charlist(char c) {
        if (c=='2') {
            return new char[]{'a','b','c'};
        } else if (c=='3') {
            return new char[]{'d','e','f'};
        } else if (c=='4') {
            return new char[]{'g','h','i'};
        } else if (c=='5') {
            return new char[]{'j','k','l'};
        } else if(c=='6') {
            return new char[]{'m','n','o'};
        } else if(c=='7') {
            return new char[]{'p','q','r','s'};
        } else if (c=='8') {
            return new char[]{'t','u','v'};
        } else {
            return new char[]{'w','x','y','z'};
        }
    }
}
