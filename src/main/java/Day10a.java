import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class Day10a {

    private static final int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        Day10 handler = new Day10();
        handler.readInput();
        int score = 0;

        for (int i = 0; i < handler.getInput().size(); i++) {
            for (int j = 0; j < handler.getInput().get(i).length; j++) {
                if (handler.getInput().get(i)[j] == 0) {
                    score += validTrail(handler.getInput(), new HashSet<>(), i, j, 0);
                }
            }
        }

        System.out.println(score);
    }

    private static int validTrail(ArrayList<int[]> input, HashSet<Point> visited, int i, int j, int step) {
        if (i < 0 || i >= input.size() || j < 0 || j >= input.get(i).length) {
            return 0;
        } else if (input.get(i)[j] != step) {
            return 0;
        } else if (step == 9 && !visited.contains(new Point(i, j))) {
            visited.add(new Point(i, j));
            return 1;
        }

        int score = 0;

        for (int[] direction : directions) {
            score += validTrail(input, visited, i + direction[0], j + direction[1], step + 1);
        }

        return score;
    }
}
