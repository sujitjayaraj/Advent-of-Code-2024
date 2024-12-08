import lombok.Data;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@Data
public class Day8 {

    private int[] dimensions;

    private HashMap<Character, ArrayList<Point>> input;

    public Day8() {
        this.dimensions = new int[2];
        this.input = new HashMap<>();
    }

    public void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/main/resources/input/Day8"));
        String line = br.readLine();
        dimensions[1] = line.length();

        while (line != null) {
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) != '.') {
                    if (!input.containsKey(line.charAt(i))) {
                        input.put(line.charAt(i), new ArrayList<>());
                    }

                    input.get(line.charAt(i)).add(new Point(dimensions[0], i));
                }
            }

            dimensions[0]++;
            line = br.readLine();
        }

        br.close();
    }
}
