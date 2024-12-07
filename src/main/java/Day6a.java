import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

public class Day6a {

    public static void main(String[] args) throws IOException {
        Day6 handler = new Day6();
        handler.readInput();
        int x = handler.getStart()[0], y = handler.getStart()[1], result = 0, direction = 0;
        HashMap<Integer, HashSet<Integer>> visited = new HashMap<>();

        while (x >=0 && x < handler.getDimensions()[0] && y >= 0 && y < handler.getDimensions()[1]) {
            if (handler.getObstacles().get(x).contains(y)) {
                x -= Day6.directions[direction][0];
                y -= Day6.directions[direction][1];
                direction = (direction + 1) % Day6.directions.length;
                x += Day6.directions[direction][0];
                y += Day6.directions[direction][1];
            }

            HashSet<Integer> row;

            if (visited.containsKey(x)) {
                row = visited.get(x);
            } else {
                row = new HashSet<>();
                visited.put(x, row);
            }

            if (!row.contains(y)) {
                result++;
                row.add(y);
            }

            x += Day6.directions[direction][0];
            y += Day6.directions[direction][1];
        }

        System.out.println(result);
    }
}
