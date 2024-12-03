import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day2b {

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

            if (Day2a.isIncreasing(report) || Day2a.isDecreasing(report)) {
                count++;
            } else {
                for (int i = 0; i < report.size(); i++) {
                    Integer j = report.remove(i);

                    if (Day2a.isIncreasing(report) || Day2a.isDecreasing(report)) {
                        count++;
                        break;
                    }

                    report.add(i, j);
                }
            }

            line = br.readLine();
        }

        br.close();
        System.out.println(count);
    }
}
