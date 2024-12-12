import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day11 {
    public String[] readInput() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/main/resources/input/Day11"));
        String line = br.readLine();
        return line.split(" ");
    }
}
