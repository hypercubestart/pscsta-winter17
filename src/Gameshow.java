import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Gameshow {
    public static void main(String[] args) throws Exception {
        String testPath = "gameshow.in";
        String judgePath = "/Volumes/NO NAME/judge data/gameshow.in";

        Scanner in = new Scanner(new File(judgePath));
        int numChallenges = Integer.parseInt(in.nextLine());
        String[] arr1 = in.nextLine().split(" ");
        String[] arr2 = in.nextLine().split(" ");
        int[] costs = new int[numChallenges];
        int[] rewards = new int[numChallenges];
        int numContestants = Integer.parseInt(in.nextLine());
        Challenge[] challenges = new Challenge[numChallenges];

        for (int i = 0; i < numChallenges; i++) {
            costs[i] = Integer.parseInt(arr1[i]);
            rewards[i] = Integer.parseInt(arr2[i]);
            challenges[i] = new Challenge(costs[i],rewards[i]);
        }

        Arrays.sort(challenges);

        for (int i=0; i <numContestants; i++) {
            int money = Integer.parseInt(in.nextLine());

            for (int j=0;j<challenges.length; j++) {
                Challenge challenge = challenges[j];
                if (challenge.reward > challenge.cost) {
                    if (money>=challenge.cost) {
                        money = money - challenge.cost + challenge.reward;
                    }
                }
            }
            System.out.println(money);
        }
    }

    public static class Challenge implements Comparable<Challenge> {
        public int cost;
        public int reward;
        public Challenge(int cost, int reward) {
            this.cost = cost;
            this.reward = reward;
        }
        @Override
        public int compareTo(Challenge o) {
            return this.cost-o.cost;
        }
    }
}
