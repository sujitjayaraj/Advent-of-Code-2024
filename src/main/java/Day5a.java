import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Day5a {

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
            result += checkUpdate(line);
            line = br.readLine();
        }

        br.close();
        System.out.println(result);
    }

    private static int checkUpdate(String line) {
        String[] row = line.split(",");
        HashSet<Integer> update = new HashSet<>();

        for (String s: row) {
            Integer i = Integer.parseInt(s);

            if (rules.containsKey(i)) {
                for(Integer j: rules.get(i)) {
                    if (update.contains(j)) {
                        return 0;
                    }
                }
            }

            update.add(i);
        }

        return Integer.parseInt(row[row.length/2]);
    }
}
