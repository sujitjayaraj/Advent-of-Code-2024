import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class Day9b {

    public static void main(String[] args) throws IOException {
        Day9 handler = new Day9();
        handler.readInput();
        ArrayList<int[]> usedDisk = new ArrayList<>();
        int start = 0, index = 0;
        HashSet<Integer> moved = new HashSet<>();

        for (int i = 0; i < handler.getInput().length; i++) {
            int end = start + handler.getInput()[i] - 1;

            if (i % 2 == 0) {
                usedDisk.add(new int[]{index++, start, end});
            }

            start = end + 1;
        }

        for (int i = usedDisk.size() - 1; i >= 0; i--) {
            if(moved.contains(usedDisk.get(i)[0])) {
                continue;
            }

            moved.add(usedDisk.get(i)[0]);

            for (int j = 0; j < i; j++) {
                int free = usedDisk.get(j + 1)[1] - usedDisk.get(j)[2] - 1;
                int required = usedDisk.get(i)[2] - usedDisk.get(i)[1] + 1;

                if (required <= free) {
                    int[] block = usedDisk.remove(i++);
                    block[1] = usedDisk.get(j)[2] + 1;
                    block[2] = block[1] + required - 1;
                    usedDisk.add(j + 1, block);
                    break;
                }
            }
        }

        long checksum = 0;

        for (int[] block: usedDisk) {
            for (int i = block[1]; i <= block[2]; i++) {
                checksum += (long)i * block[0];
            }
        }

        System.out.println(checksum);
    }
}
