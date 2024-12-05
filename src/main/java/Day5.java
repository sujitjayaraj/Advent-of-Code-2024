import lombok.Data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

@Data
public class Day5 {

    private HashMap<Integer, HashSet<Integer>> rules;

    private ArrayList<Integer[]> updates;

    public Day5() {
        rules = new HashMap<>();
        updates = new ArrayList<>();
    }

    void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/main/resources/input/Day5"));
        String line = br.readLine();

        while (!line.isEmpty()) {
            Integer[] row = Arrays.stream(line.split("\\|")).map(Integer::valueOf).toArray(Integer[]::new);

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
            Integer[] update = Arrays.stream(line.split(",")).map(Integer::valueOf).toArray(Integer[]::new);
            updates.add(update);
            line = br.readLine();
        }

        br.close();
    }

    private int compare(Integer a, Integer b) {
        if (rules.containsKey(a) && rules.get(a).contains(b)) {
            return -1;
        } else if (rules.containsKey(b) && rules.get(b).contains(a)) {
            return 1;
        }

        return 0;
    }

    ArrayList<Integer[]> sortUpdates() {
        ArrayList<Integer[]> copy = new ArrayList<>();

        for (Integer[] update: updates) {
            Integer[] row = Arrays.copyOf(update, update.length);
            Arrays.sort(row, this::compare);
            copy.add(row);
        }

        return copy;
    }
}
