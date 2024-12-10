import lombok.Data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

@Data
public class Day10 {

    private ArrayList<int[]> input;

    public Day10() {
        this.input = new ArrayList<>();
    }

    public void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/main/resources/input/Day10"));
        String line = br.readLine();

        while (line != null) {
            int[] row = Arrays.stream(line.split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            input.add(row);
            line = br.readLine();
        }
    }
}
