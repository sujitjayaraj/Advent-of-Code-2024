package Day14;

import java.io.IOException;
import java.util.ArrayList;

public class Day14a {

    public static void main(String[] args) throws IOException {
        Day14 handler = new Day14();
        handler.readInput();
        ArrayList<int[]> positions = handler.getPositions();
        ArrayList<int[]> velocities = handler.getVelocities();

        for (int i = 0; i < 100; i++) {
            move(positions, velocities);
        }

        int[] quadrants = new int[4];

        for (int[] position : positions) {
            if (position[0] < 51 && position[1] < 50) {
                quadrants[0]++;
            } else if (position[0] < 51 && position[1] > 50) {
                quadrants[1]++;
            } else if (position[0] > 51 && position[1] < 50) {
                quadrants[2]++;
            } else if (position[0] > 51 && position[1] > 50) {
                quadrants[3]++;
            }
        }

        System.out.println(quadrants[0] * quadrants[1] * quadrants[2] * quadrants[3]);
    }

    public static void move(ArrayList<int[]> positions, ArrayList<int[]> velocities) {
        for (int i = 0; i < positions.size(); i++) {
            int[] position = positions.get(i);
            int[] velocity = velocities.get(i);
            position[0] += velocity[0];
            position[1] += velocity[1];

            if (position[0] < 0) {
                position[0] += 103;
            } else if (position[0] > 102) {
                position[0] -= 103;
            }

            if (position[1] < 0) {
                position[1] += 101;
            } else if (position[1] > 100) {
                position[1] -= 101;
            }
        }
    }
}
