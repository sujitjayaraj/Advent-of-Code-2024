package Day14;

import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class Day14b {

    public static void main(String[] args) throws IOException {
        Day14 handler = new Day14();
        handler.readInput();
        ArrayList<int[]> positions = handler.getPositions();
        ArrayList<int[]> velocities = handler.getVelocities();
        int time = 0;

        while(true) {
            HashSet<Point> set = new HashSet<>();
            boolean collision = false;
            time++;
            Day14a.move(positions, velocities);

            for (int[] position : positions) {
                Point point = new Point(position[0], position[1]);

                if (set.contains(point)) {
                    collision = true;
                    break;
                }

                set.add(point);
            }

            if (!collision) {
                break;
            }
        }

        System.out.println(time);
    }
}
