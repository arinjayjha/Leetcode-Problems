class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();
        Boolean[][] memo = new Boolean[n + 1][m + 1];
        return dfs(0, 0, s, p, memo);
    }

    private boolean dfs(int i, int j, String s, String p, Boolean[][] memo) {
        if (memo[i][j] != null) return memo[i][j];

        int n = s.length(), m = p.length();
        boolean ans;

        if (j == m) {
            ans = (i == n);
        } else {
            boolean firstMatch = (i < n) && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

            if (j + 1 < m && p.charAt(j + 1) == '*') {
                // Skip char*  OR  consume one if firstMatch
                ans = dfs(i, j + 2, s, p, memo) || (firstMatch && dfs(i + 1, j, s, p, memo));
            } else {
                ans = firstMatch && dfs(i + 1, j + 1, s, p, memo);
            }
        }

        return memo[i][j] = ans;
    }
}
