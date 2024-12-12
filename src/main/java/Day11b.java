import java.io.IOException;
import java.util.HashMap;

public class Day11b {

    public static void main(String[] args) throws IOException {
        Day11 handler = new Day11();
        String[] stones = handler.readInput();
        HashMap<String, HashMap<Integer, Long>> cache = new HashMap<>();
        long count = 0;

        for (String stone : stones) {
            count += Day11a.blink(stone, 75, cache);
        }

        System.out.println(count);
    }
}
