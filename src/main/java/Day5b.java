import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Day5b {

    private static HashMap<Integer, HashSet<Integer>> rules;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/main/resources/input/Day5"));
        rules = new HashMap<>();
        String line = br.readLine();
        int result = 0;

        while (!line.isEmpty()) {
            Integer[] row = Arrays.stream(line.split("\\|")).map(Integer::parseInt).toArray(Integer[]::new);

            if (!rules.containsKey(row[0])) {
                HashSet<Integer> set = new HashSet<>();
                set.add(row[1]);
                rules.put(row[0], set);
            } else {
                rules.get(row[0]).add(row[1]);
            }

            line = br.readLine();
        }

        line = br.readLine();

        while (line != null) {
            Integer[] update = Arrays.stream(line.split(",")).map(Integer::parseInt).toArray(Integer[]::new);
            Integer[] copy = Arrays.copyOf(update, update.length);
            Arrays.sort(update, Day5b::compare);
            result += Arrays.equals(copy, update) ? 0 : update[update.length/2];
            line = br.readLine();
        }

        br.close();
        System.out.println(result);
    }

    private static int compare(Integer a, Integer b) {
        if (rules.containsKey(a) && rules.get(a).contains(b)) {
            return -1;
        } else if (rules.containsKey(b) && rules.get(b).contains(a)) {
            return 1;
        }

        return 0;
    }
}