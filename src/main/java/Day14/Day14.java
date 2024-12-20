package Day14;

import lombok.Data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

@Data
public class Day14 {

    private ArrayList<int[]> positions;

    private ArrayList<int[]> velocities;

    Day14() {
        positions = new ArrayList<>();
        velocities = new ArrayList<>();
    }

    public void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/main/resources/input/Day14"));
        String line = br.readLine();

        while (line != null) {
            String[] parts = line.split(" ");
            String[] subparts = parts[0].split(",");
            int[] position = new int[2];
            position[1] = Integer.parseInt(subparts[0].substring(2));
            position[0] = Integer.parseInt(subparts[1]);
            positions.add(position);
            subparts = parts[1].split(",");
            int[] velocity = new int[2];
            velocity[1] = Integer.parseInt(subparts[0].substring(2));
            velocity[0] = Integer.parseInt(subparts[1]);
            velocities.add(velocity);

            line = br.readLine();
        }

        br.close();
    }
}
