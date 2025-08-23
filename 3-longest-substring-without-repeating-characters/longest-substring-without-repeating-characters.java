class Solution {
    //arinjay
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        for (int i = 0; i < n; i++) {
            boolean[] seen = new boolean[128];
            for (int j = i; j < n; j++) {
                char c = s.charAt(j);
                if (seen[c]) break;
                seen[c] = true;
                ans = Math.max(ans, j - i + 1);
            }
        }
        return ans;
    }
}
