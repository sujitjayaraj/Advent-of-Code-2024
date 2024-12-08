import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class Day8b {

    private static HashSet<Point> uniquePoints;

    public static void main(String[] args) throws IOException {
        Day8 handler = new Day8();
        handler.readInput();
        uniquePoints = new HashSet<>();

        for (ArrayList<Point> points: handler.getInput().values()) {
            getAntiNodes(points, handler.getDimensions());
        }

        System.out.println(uniquePoints.size());
    }

    private static void getAntiNodes(ArrayList<Point> points, int[] dimensions) {
        for (int i = 0; i < dimensions[0]; i++) {
            for (int j = 0; j < dimensions[1]; j++) {
                for (int k = 0; k < points.size(); k++) {
                    for (int l = k + 1; l < points.size(); l++) {
                        int x1 = points.get(k).x;
                        int x2 = points.get(l).x;
                        int y1 = points.get(k).y;
                        int y2 = points.get(l).y;

                        boolean checkLinear = x1 * (y2 - j) + x2 * (j - y1) + i * (y1 - y2) == 0;

                        if (checkLinear) {
                            uniquePoints.add(new Point(i, j));
                        }
                    }
                }
            }
        }
    }
}
