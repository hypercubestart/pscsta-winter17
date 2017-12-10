import java.io.File;
import java.util.Scanner;

public class Congress {
    public static void main(String[] args) throws Exception {
        String testPath = "congress.in";
        String judgePath = "/Volumes/NO NAME/judge data/congress.in";

        Scanner in = new Scanner(new File(judgePath));
        int numCases = Integer.parseInt(in.nextLine());

        for (int i = 0; i < numCases; i++) {
            int numSpecies = Integer.parseInt(in.nextLine());
            double minTemp = Double.MIN_VALUE, minLight = Double.MIN_VALUE, maxTemp = Double.MAX_VALUE, maxLight = Double.MAX_VALUE;
            for (int j = 0; j < numSpecies; j++) {
                String[] array = in.nextLine().split(" ");
                double minTempS = Double.parseDouble(array[0]);
                double maxTempS = Double.parseDouble(array[1]);
                double minLightS = Double.parseDouble(array[2]);
                double maxLightS = Double.parseDouble(array[3]);

                if (minTempS > minTemp) minTemp = minTempS;
                if (minLightS > minLight) minLight = minLightS;
                if (maxTempS < maxTemp) maxTemp = maxTempS;
                if (maxLightS < maxLight) maxLight = maxLightS;

            }

            if (minLight > maxLight || minTemp > maxTemp) System.out.println("FAILURE");
            else System.out.println(minTemp + " " + maxTemp + " " + minLight + " " + maxLight);
        }
    }
}
