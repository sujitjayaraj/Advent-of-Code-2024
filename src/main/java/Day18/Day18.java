package Day18;

import lombok.Data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

@Data
public class Day18 {

    private int[][] input;

    public void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/main/resources/input/Day18"));
        input = br.lines()
                .map(line -> line.split(","))
                .map(arr -> Arrays.stream(arr).mapToInt(Integer::parseInt).toArray())
                .toArray(int[][]::new);
    }
}
