import lombok.Data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

@Data
public class Day7 {

    private final ArrayList<Long> tests;

    private final ArrayList<long[]> numbers;

    public Day7() {
        this.tests = new ArrayList<>();
        this.numbers = new ArrayList<>();
    }

    void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/main/resources/input/Day7"));
        String line = br.readLine();

        while (line != null) {
            tests.add(Long.valueOf(line.substring(0, line.indexOf(':'))));
            long[] row = Arrays.stream(line.substring(line.indexOf(':') + 2).split("\\s")).mapToLong(Long::parseLong).toArray();
            numbers.add(row);

            line = br.readLine();
        }

        br.close();
    }
}
