import java.io.IOException;
import java.util.ArrayList;

public class Day4b {

    public static void main(String[] args) throws IOException {
        Day4 handler = new Day4();
        handler.readInput();
        int result = 0;

        for (int i = 0; i < handler.getInput().size(); i++) {
            for (int j = 0; j < handler.getInput().get(i).size(); j++) {
                if (handler.getInput().get(i).get(j) == 'A' && countWord(handler.getInput(), i, j)) {
                    result++;
                }
            }
        }

        System.out.println(result);
    }

    private static boolean countWord(ArrayList<ArrayList<Character>> input, int i, int j) {
        if (i == 0 || i == input.size() - 1 || j == 0 || j == input.get(i).size() - 1) {
            return false;
        }

        char a = input.get(i - 1).get(j - 1);
        char b = input.get(i + 1).get(j + 1);

        boolean diag1 = a == 'M' && b == 'S' || a == 'S' && b == 'M';

        a = input.get(i - 1).get(j + 1);
        b = input.get(i + 1).get(j - 1);

        boolean diag2 = a == 'M' && b == 'S' || a == 'S' && b == 'M';

        return diag1 && diag2;
    }
}
