import java.util.ArrayList;

public class Challenge {

    static ArrayList<Coordinate> searched = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        boolean[][] map = new boolean[][] {
                {false, true, false, true, false},
                {true, true, true, true, true},
                {false, true, false, true, false},
                {true, true, true, true, true},
                {false, true, false, true, false}
        };

        /*boolean[][] map = new boolean[][] {
                {false, true, false, true, false},
                {true, true, false, false, true},
                {false, true, false, true, false},
                {true, true, false, true, true}
        };*/

        System.out.println(islands(map));
    }

    public static int islands(boolean[][] map) {
        int counter = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (contains(searched, new Coordinate(i, j))) continue;
                if (!map[i][j]) searched.add(new Coordinate(i, j));
                else {
                    findIsland(i, j, map);
                    counter++;
                }
            }
        }
        return counter;
    }

    public static ArrayList<Coordinate> findIsland(int i, int j, boolean[][] map) {
        ArrayList<Coordinate> lands = new ArrayList<>();
        lands.add(new Coordinate(i, j));
        searched.add(new Coordinate(i, j));

        for (int k = -1; k <= 1; k += 2) {
            if (i + k < map.length && i + k >= 0 &&!contains(searched, new Coordinate(i + k, j))) {
                if (map[i + k][j]) lands.addAll(findIsland(i + k, j, map));
                else searched.add(new Coordinate(i + k, j));
            }

            if (j + k < map[0].length && j + k >= 0 && !contains(searched, new Coordinate(i, j + k))) {
                if (map[i][j + k]) lands.addAll(findIsland(i, j + k, map));
                else searched.add(new Coordinate(i, j + k));
            }
        }

        return lands;
    }

    private static class Coordinate {
        int i, j;

        public Coordinate(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    private static boolean contains(ArrayList<Coordinate> list, Coordinate test) {
        for (Coordinate coordinate : list) {
            if (coordinate.i == test.i && coordinate.j == test.j) return true;
        }
        return false;
    }
}
