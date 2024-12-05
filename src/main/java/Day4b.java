import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day4b {

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
                if (input.get(i).get(j) == 'A' && countWord(input, i, j)) {
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
