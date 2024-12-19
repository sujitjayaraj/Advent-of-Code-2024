package Day19;

import lombok.Data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Data
public class Day19 {

    private String[] patterns;

    private String[] designs;

    public void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/main/resources/input/Day19"));
        patterns = br.readLine().split(", ");
        br.readLine();
        designs = br.lines().toArray(String[]::new);
    }
}
