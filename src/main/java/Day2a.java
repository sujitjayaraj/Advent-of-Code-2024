import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day2a {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/main/resources/input/Day2"));
        String line = br.readLine();
        int count = 0;

        while (line != null) {
            String[] arr = line.split(" ");
            ArrayList<Integer> report = new ArrayList<>();

            for (String i: arr) {
                report.add(Integer.parseInt(i));
            }

            if (isIncreasing(report)) {
                count++;
            } else if (isDecreasing(report)) {
                count++;
            }

            line = br.readLine();
        }

        br.close();
        System.out.println(count);
    }

    static boolean isIncreasing(ArrayList<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i + 1) || list.get(i + 1) - list.get(i) > 3) {
                return false;
            }
        }

        return true;
    }

    static boolean isDecreasing(ArrayList<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) <= list.get(i + 1) || list.get(i) - list.get(i + 1) > 3) {
                return false;
            }
        }

        return true;
    }
}
