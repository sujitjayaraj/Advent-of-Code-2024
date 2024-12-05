import lombok.Data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

@Data
public class Day4 {

    private ArrayList<ArrayList<Character>> input;

    protected Day4() {
        input = new ArrayList<>();
    }

    protected void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/main/resources/input/Day4"));
        String line = br.readLine();

        while (line != null) {
            ArrayList<Character> row = new ArrayList<>();

            for (char c: line.toCharArray()) {
                row.add(c);
            }

            input.add(row);
            line = br.readLine();
        }
    }
}
