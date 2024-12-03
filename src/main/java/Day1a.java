import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Day1a {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/main/resources/input/Day1"));
        String line = br.readLine();
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        while (line != null) {
            String[] arr = line.trim().split("\\s+");
            list1.add(Integer.parseInt(arr[0]));
            list2.add(Integer.parseInt(arr[1]));
            line = br.readLine();
        }

        Collections.sort(list1);
        Collections.sort(list2);

        long result = 0;

        for (int i = 0; i < list1.size(); i++) {
            result += Math.abs(list1.get(i) - list2.get(i));
        }

        br.close();

        System.out.println(result);
    }
}
