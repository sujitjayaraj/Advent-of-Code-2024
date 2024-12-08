import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class Day8a {

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

                        boolean checkDistance1 = Math.pow(i - x1, 2) + Math.pow(j - y1, 2) == 4 * (Math.pow(i - x2, 2) + Math.pow(j - y2, 2));
                        boolean checkDistance2 = Math.pow(i - x2, 2) + Math.pow(j - y2, 2) == 4 * (Math.pow(i - x1, 2) + Math.pow(j - y1, 2));
                        boolean checkLinear = x1 * (y2 - j) + x2 * (j - y1) + i * (y1 - y2) == 0;

                        if ((checkDistance1 || checkDistance2) && checkLinear) {
                            uniquePoints.add(new Point(i, j));
                        }
                    }
                }
            }
        }
    }
}
