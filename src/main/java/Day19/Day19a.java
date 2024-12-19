package Day19;

import java.io.IOException;

public class Day19a {

    public static void main(String[] args) throws IOException {
        Day19 handler = new Day19();
        handler.readInput();
        String[] patterns = handler.getPatterns();
        String[] designs = handler.getDesigns();
        int count = 0;

        for (String design : designs) {
            if(canFormString(design, patterns)) {
                count++;
            }
        }

        System.out.println(count);
    }

    // This method uses dynamic programming to determine if a string can be formed by concatenating patterns
    private static boolean canFormString(String design, String[] patterns) {
        boolean[] dp = new boolean[design.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= design.length(); i++) {
            for (String pattern : patterns) {
                if (i >= pattern.length() && design.startsWith(pattern, i - pattern.length())) {
                    dp[i] = dp[i] || dp[i - pattern.length()];
                }
            }
        }

        return dp[design.length()];
    }
}
