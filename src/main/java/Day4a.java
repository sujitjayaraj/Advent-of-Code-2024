import java.io.IOException;
import java.util.ArrayList;

public class Day4a {

    private static final char[] word = {'X', 'M', 'A', 'S'};

    private static final int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, -1}, {-1, 1}};

    public static void main(String[] args) throws IOException {
        Day4 handler = new Day4();
        handler.readInput();
        int result = 0;

        for (int i = 0; i < handler.getInput().size(); i++) {
            for (int j = 0; j < handler.getInput().get(i).size(); j++) {
                if (handler.getInput().get(i).get(j) == word[0]) {
                    result += countWord(handler.getInput(), i, j);
                }
            }
        }

        System.out.println(result);
    }

    private static int countWord(ArrayList<ArrayList<Character>> input, int i, int j) {
        int count = 0;

        for (int[] direction: directions) {
            int x = i, y = j;

            for (int k = 1; k < word.length; k++) {
                x += direction[0];
                y += direction[1];

                if (x < 0 || x >= input.size() || y < 0 || y >= input.get(x).size() || input.get(x).get(y) != word[k]) {
                    break;
                }

                if (k == word.length - 1) {
                    count++;
                }
            }
        }

        return count;
    }
}
