import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class ChallengeAndy {
    public static void main(String[] args) {
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
        boolean[][] visited = new boolean[map.length][map[0].length];

        int counter = 0;

        for (int i = 0; i<map.length; i++) {
            for (int j=0; j<map[0].length; j++) {
                if (map[i][j]) {
                    if (!visited[i][j]) {
                        Queue<Coordinate> queue = new LinkedList<>();

                        counter++;
                        queue.add(new Coordinate(i, j));

                        while (!queue.isEmpty()) {
                            Coordinate c = queue.remove();
                            visited[c.i][c.j] = true;

                            try {
                                if (map[c.i + 1][c.j]) {
                                    queue.add(new Coordinate(c.i + 1, c.j));
                                }
                            } catch (Exception e) {
                            }

                            try {
                                if (map[c.i][c.j + 1]) {
                                    queue.add(new Coordinate(c.i, c.j + 1));
                                }
                            } catch (Exception e) {
                            }
                        }
                    }
                }
            }
        }
        return counter;

    }

    public static class Coordinate {
        public int i;
        public int j;
        public Coordinate(int i, int j) {
            this.i  = i;
            this.j = j;
        }


    }

}
