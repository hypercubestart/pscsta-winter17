import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Challenge {

    static ArrayList<Coordinate> water = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        boolean[][] map = new boolean[][] {
                {true, true, false, true},
                {true, false, false, true},
                {true, true, false, false},
                {true, true, false, true},
        };

        System.out.println(islands(map));
    }

    public static int islands(boolean[][] map) {

        ArrayList<Island> islands = new ArrayList<>();

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length && !isAccountedFor(i, j, islands, water); j++) {
                if (!map[i][j]) water.add(new Coordinate(i, j));
                else {
                    Island island = new Island(findIsland(i, j, map, new ArrayList<>()));
                    islands.add(island);
                }
            }
        }
        return islands.size();
    }

    public static ArrayList<Coordinate> findIsland(int i, int j, boolean[][] map, ArrayList<Coordinate> traversed) {
        ArrayList<Coordinate> lands = new ArrayList<>();
        lands.add(new Coordinate(i, j));
        traversed.add(new Coordinate(i, j));
        if (i - 1 >= 0 && i - 1 < map.length && !contains(traversed, new Coordinate(i - 1, j))) {
            if (map[i - 1][j]) lands.addAll(findIsland(i - 1, j, map, traversed));
            else water.add(new Coordinate(i - 1, j));
        }
        if (i + 1 >= 0 && i + 1 < map.length && !contains(traversed, new Coordinate(i + 1, j))) {
            if (map[i + 1][j]) lands.addAll(findIsland(i + 1, j, map, traversed));
            else water.add(new Coordinate(i + 1, j));
        }
        if (j + 1 >= 0 && j + 1 < map[0].length && !contains(traversed, new Coordinate(i, j + 1))) {
            if (map[i][j + 1]) lands.addAll(findIsland(i, j + 1, map, traversed));
            else water.add(new Coordinate(i, j + 1));
        }
        if (j - 1 >= 0 && j - 1 < map[0].length && !contains(traversed, new Coordinate(i, j - 1))) {
            if (map[i][j - 1]) lands.addAll(findIsland(i, j - 1, map, traversed));
            else water.add(new Coordinate(i, j - 1));
        }
        return lands;

    }

    public static boolean isAccountedFor(int i, int j, ArrayList<Island> islands, ArrayList<Coordinate> water) {
        for (Island island : islands) {
            for (Coordinate coordinate : island.locations) {
                if (coordinate.x == i && coordinate.y == j) return true;
            }
        }
        for (Coordinate coordinate : water) {
            if (coordinate.x == i && coordinate.y == j) return true;
        }
        return false;
    }

    private static class Island {
        ArrayList<Coordinate> locations;

        public Island(ArrayList<Coordinate> locations) {
            this.locations = locations;
        }
    }

    private static class Coordinate {
        int x, y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static boolean contains(ArrayList<Coordinate> list, Coordinate test) {
        for (Coordinate coordinate : list) {
            if (coordinate.x == test.x && coordinate.y == test.y) return true;
        }
        return false;
    }
}
