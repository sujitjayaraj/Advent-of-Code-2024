import lombok.Data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

@Data
public class Day6 {
    public static final int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private final ArrayList<HashSet<Integer>> obstacles;

    private final ArrayList<HashSet<Integer>> free;

    private final int[] start;

    private final int[] dimensions;

    public Day6() {
        obstacles = new ArrayList<>();
        free = new ArrayList<>();
        start = new int[2];
        dimensions = new int[2];
    }

    public void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/main/resources/input/Day6"));
        String line = br.readLine();
        int lineNumber = 0;
        dimensions[1] = line.length();

        while (line != null) {
            HashSet<Integer> obstacleRow = new HashSet<>();
            HashSet<Integer> freeRow = new HashSet<>();
            dimensions[0]++;

            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == '#') {
                    obstacleRow.add(i);
                } else if (line.charAt(i) == '.') {
                    freeRow.add(i);
                } else if (line.charAt(i) == '^') {
                    start[0] = lineNumber;
                    start[1] = i;
                }
            }

            obstacles.add(obstacleRow);
            free.add(freeRow);
            lineNumber++;

            line = br.readLine();
        }
    }
}
