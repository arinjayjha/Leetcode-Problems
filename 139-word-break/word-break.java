class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        Set<String> set = new HashSet<>(wordDict);

        int n = s.length();

        // dp[i] = true if s[0...i-1] can be formed
        boolean[] dp = new boolean[n + 1];

        // Empty string can always be formed
        dp[0] = true;

        for (int i = 1; i <= n; i++) {

            for (int j = 0; j < i; j++) {

                // If the previous part can be formed
                // and s[j...i-1] is a dictionary word
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}