import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3b {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("src/main/resources/input/Day3"));
        String regex = "mul\\(\\d{1,3},\\d{1,3}\\)|do(n't)?\\(\\)";
        Pattern pattern = Pattern.compile(regex);
        String line = br.readLine();
        boolean flag = true;
        long result = 0;

        while (line != null) {
            Matcher matcher = pattern.matcher(line);

            while (matcher.find()) {
                String match = matcher.group();

                if (match.equals("do()")) {
                    flag = true;
                }
                else if(match.equals("don't()")) {
                    flag = false;
                }
                else if (flag){
                    result += Long.parseLong(match.substring(4, match.indexOf(','))) * Long.parseLong(match.substring(match.indexOf(',') + 1, match.length() - 1));
                }
            }

            line = br.readLine();
        }

        br.close();
        System.out.println(result);
    }
}
