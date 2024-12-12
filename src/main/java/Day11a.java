import java.io.IOException;
import java.util.HashMap;

public class Day11a {

    public static void main(String[] args) throws IOException {
        Day11 handler = new Day11();
        String[] stones = handler.readInput();
        HashMap<String, HashMap<Integer, Long>> cache = new HashMap<>();
        long count = 0;

        for (String stone : stones) {
            count += blink(stone, 25, cache);
        }

        System.out.println(count);
    }

    static long blink(String stone, int iterationsLeft, HashMap<String, HashMap<Integer, Long>> cache) {
        if (iterationsLeft == 0) {
            return 1;
        } else if (cache.containsKey(stone) && cache.get(stone).containsKey(iterationsLeft)) {
            return cache.get(stone).get(iterationsLeft);
        }

        long count;
        cache.putIfAbsent(stone, new HashMap<>());

        if (stone.equals("0")) {
            count = blink("1", iterationsLeft - 1, cache);
        } else if (stone.length() % 2 == 0) {
            count = blink(stone.substring(0, stone.length() / 2), iterationsLeft - 1, cache) + blink(String.valueOf(Long.parseLong(stone.substring(stone.length() / 2))), iterationsLeft - 1, cache);
        } else {
            count = blink(String.valueOf(Long.parseLong(stone) * 2024), iterationsLeft - 1, cache);
        }

        cache.get(stone).put(iterationsLeft, count);

        return count;
    }
}
