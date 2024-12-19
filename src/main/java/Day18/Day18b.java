package Day18;

import java.io.IOException;

public class Day18b {

    public static void main(String[] args) throws IOException {
        Day18 handler = new Day18();
        handler.readInput();
        int[][] input = handler.getInput();
        boolean[][] space = new boolean[71][71];

        for (int[] obstacle : input) {
            space[obstacle[0]][obstacle[1]] = true;

            if (Day18a.findShortestPath(space) == -1) {
                System.out.println(obstacle[0] + "," + obstacle[1]);
                break;
            }
        }
    }
}
