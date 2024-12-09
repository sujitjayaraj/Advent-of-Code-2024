import lombok.Data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Data
public class Day9 {

    private byte[] input;

    public void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/main/resources/input/Day9"));
        String line = br.readLine();
        input = new byte[line.length()];

        for (int i = 0; i < line.length(); i++) {
            input[i] = (byte)(line.charAt(i) - '0');
        }
    }
}
