class Solution {
    public int minCut(String s) {
        int n = s.length();

        // pal[i][j] = true if s[i...j] is a palindrome
        boolean[][] pal = new boolean[n][n];

        // Build palindrome table
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {

                if (s.charAt(i) == s.charAt(j) &&
                    (j - i <= 1 || pal[i + 1][j - 1])) {

                    pal[i][j] = true;
                }
            }
        }

        // dp[i] = minimum cuts needed for s[0...i]
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = i; // Worst case: cut before every character

            if (pal[0][i]) {
                dp[i] = 0;
            } else {
                for (int j = 1; j <= i; j++) {

                    if (pal[j][i]) {
                        dp[i] = Math.min(
                            dp[i],
                            dp[j - 1] + 1
                        );
                    }
                }
            }
        }

        return dp[n - 1];
    }
}