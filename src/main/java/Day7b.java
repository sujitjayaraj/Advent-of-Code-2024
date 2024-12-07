import java.io.IOException;

public class Day7b {

    public static void main(String[] args) throws IOException {
        Day7 handler = new Day7();
        handler.readInput();
        long result = 0;

        for (int i = 0; i < handler.getTests().size(); i++) {
            boolean valid = recursiveCheck(handler.getTests().get(i), handler.getNumbers().get(i), handler.getNumbers().get(i)[0], 1);

            if(valid) {
                result += handler.getTests().get(i);
            }
        }

        System.out.println(result);
    }

    private static boolean recursiveCheck(long target, long[] row, long result, int index) {
        if (result == target && index == row.length) {
            return true;
        } else if(result > target || index >= row.length) {
            return false;
        }

        return recursiveCheck(target, row, result + row[index], index + 1) || recursiveCheck(target, row, result * row[index], index + 1) ||
                recursiveCheck(target, row, Long.parseLong(String.valueOf(result).concat(String.valueOf(row[index]))), index + 1);
    }
}
