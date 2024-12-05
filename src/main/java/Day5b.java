import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Day5b {

    public static void main(String[] args) throws IOException {
        Day5 handler = new Day5();
        handler.readInput();
        ArrayList<Integer[]> sorted = handler.sortUpdates();
        int result = 0;

        for (int i = 0; i < sorted.size(); i++) {
            if (!Arrays.equals(handler.getUpdates().get(i), sorted.get(i))) {
                result += sorted.get(i)[sorted.get(i).length / 2];
            }
        }

        System.out.println(result);
    }
}