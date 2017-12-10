import java.io.File;
import java.util.Scanner;
import java.util.Stack;

public class Brackets {
    public static void main(String[] args) throws Exception {
        String testPath = "brackets.in";
        String judgePath = "/Volumes/NO NAME/judge data/brackets.in";

        Scanner in = new Scanner(new File(judgePath));
        int numCases = Integer.parseInt(in.nextLine());

        for (int i = 0; i < numCases; i++) {
            String s = in.nextLine();
            System.out.println(getBalanced(s));
        }
    }

    private static String getBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return "NOT BALANCED";
                }
                char popC = stack.pop();
                if ((popC == '{' && c != '}') || (popC == '(' && c != ')') || (popC == '[' && c != ']')) {
                    return "NOT BALANCED";
                }
            }
        }
        if (!stack.isEmpty()) {
            return "NOT BALANCED";
        } else return "BALANCED";
    }
}
