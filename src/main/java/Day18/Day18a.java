package Day18;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Day18a {

    public static void main(String[] args) throws IOException {
        Day18 handler = new Day18();
        handler.readInput();
        int[][] input = handler.getInput();
        boolean[][] space = new boolean[71][71];

        for (int i = 0; i < 1024; i++) {
            space[input[i][0]][input[i][1]] = true;
        }

        int shortestPath = findShortestPath(space);

        System.out.println(shortestPath);
    }

    protected static int findShortestPath(boolean[][] space) {
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[71][71];
        queue.offer(new int[]{0, 0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            if (current[0] == 70 && current[1] == 70) {
                return current[2];
            }

            for (int i = 0; i < 4; i++) {
                int newRow = current[0] + directions[i][0];
                int newCol = current[1] + directions[i][1];

                if (newRow >= 0 && newRow < 71 && newCol >= 0 && newCol < 71 && !visited[newRow][newCol] && !space[newRow][newCol]) {
                    queue.offer(new int[]{newRow, newCol, current[2] + 1});
                    visited[newRow][newCol] = true;
                }
            }
        }

        return -1;
    }
}
