import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day4a {

    private static final char[] word = {'X', 'M', 'A', 'S'};
    private static final int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, -1}, {-1, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/main/resources/input/Day4"));
        ArrayList<ArrayList<Character>> input = new ArrayList<>();
        String line = br.readLine();
        int result = 0;

        while (line != null) {
            ArrayList<Character> row = new ArrayList<>();

            for (char c: line.toCharArray()) {
                row.add(c);
            }

            input.add(row);
            line = br.readLine();
        }

        for (int i = 0; i < input.size(); i++) {
            for (int j = 0; j < input.get(i).size(); j++) {
                if (input.get(i).get(j) == word[0]) {
                    result += countWord(input, i, j);
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
