package Day19;

import java.io.IOException;

public class Day19b {

    public static void main(String[] args) throws IOException {
        Day19 handler = new Day19();
        handler.readInput();
        String[] patterns = handler.getPatterns();
        String[] designs = handler.getDesigns();
        long count = 0;

        for (String design : designs) {
            count += canFormString(design, patterns);
        }

        System.out.println(count);
    }

    // This method uses dynamic programming to determine the number of ways a string can be formed by concatenating patterns
    private static long canFormString(String design, String[] patterns) {
        long[] dp = new long[design.length() + 1];
        dp[0] = 1;

        for (int i = 1; i <= design.length(); i++) {
            for (String pattern : patterns) {
                if (i >= pattern.length() && design.startsWith(pattern, i - pattern.length())) {
                    dp[i] += dp[i - pattern.length()];
                }
            }
        }

        return dp[design.length()];
    }
}
