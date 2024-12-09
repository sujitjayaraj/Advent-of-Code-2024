import java.io.IOException;
import java.util.ArrayList;

public class Day9a {

    public static void main(String[] args) throws IOException {
        Day9 handler = new Day9();
        handler.readInput();
        byte[] input = handler.getInput();
        ArrayList<Integer> diskMap = new ArrayList<>();
        int index = 0;

        for (int i = 0; i < input.length; i++) {
            if (i % 2 == 0) {
                addElements(diskMap, index++, input[i]);
            } else {
                addElements(diskMap, -1, input[i]);
            }
        }

        for (int i = 0; i < diskMap.size(); i++) {
            while (diskMap.getLast() == -1) {
                diskMap.removeLast();
            }

            if (diskMap.get(i) == -1) {
                diskMap.set(i, diskMap.getLast());
                diskMap.removeLast();
            }
        }

        long checksum = 0;

        for (int i = 0; i < diskMap.size(); i++) {
            checksum += (long)i * diskMap.get(i);
        }

        System.out.println(checksum);
    }

    private static void addElements(ArrayList<Integer> diskMap, int element, int count) {
        for (int i = 0; i < count; i++) {
            diskMap.add(element);
        }
    }
}
