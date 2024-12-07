import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

public class Day6b {

    public static void main(String[] args) throws IOException {
        Day6 handler = new Day6();
        handler.readInput();
        int result = 0;

        for (int i = 0; i < handler.getFree().size(); i++) {
            for (int j : handler.getFree().get(i)) {
                int x = handler.getStart()[0], y = handler.getStart()[1], direction = 0;
                HashMap<Integer, HashMap<Integer, HashSet<Integer>>> visited = new HashMap<>();
                handler.getObstacles().get(i).add(j);

                while (x >= 0 && x < handler.getDimensions()[0] && y >= 0 && y < handler.getDimensions()[1]) {
                    if (handler.getObstacles().get(x).contains(y)) {
                        x -= Day6.directions[direction][0];
                        y -= Day6.directions[direction][1];
                        direction = (direction + 1) % Day6.directions.length;
                        x += Day6.directions[direction][0];
                        y += Day6.directions[direction][1];
                    }

                    HashMap<Integer, HashSet<Integer>> row;

                    if (visited.containsKey(x)) {
                        row = visited.get(x);
                    } else {
                        row = new HashMap<>();
                        visited.put(x, row);
                    }

                    HashSet<Integer> directionSet;

                    if (row.containsKey(y)) {
                        directionSet = row.get(y);
                    } else {
                        directionSet = new HashSet<>();
                        row.put(y, directionSet);
                    }

                    if (!directionSet.add(direction)) {
                        result++;
                        break;
                    }

                    x += Day6.directions[direction][0];
                    y += Day6.directions[direction][1];
                }

                handler.getObstacles().get(i).remove(j);
            }
        }

        System.out.println(result);
    }
}
