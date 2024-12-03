import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Day1b {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/main/resources/input/Day1"));
        String line = br.readLine();
        ArrayList<Integer> list1 = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        while (line != null) {
            String[] arr = line.trim().split("\\s+");
            list1.add(Integer.parseInt(arr[0]));
            map.put(Integer.parseInt(arr[1]), map.getOrDefault(Integer.parseInt(arr[1]), 0) + 1);
            line = br.readLine();
        }

        long result = list1.stream().map(x -> x * map.getOrDefault(x, 0)).reduce(0, Integer::sum);
        br.close();

        System.out.println(result);
    }
}
