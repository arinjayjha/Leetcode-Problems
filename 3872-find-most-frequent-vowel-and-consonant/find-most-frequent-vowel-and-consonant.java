//arinjayjha
class Solution {
    public int maxFreqSum(String s) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) cnt[c - 'a']++;
        int maxV = 0, maxC = 0;
        for (int i = 0; i < 26; i++) {
            char ch = (char) ('a' + i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                maxV = Math.max(maxV, cnt[i]);
            } else {
                maxC = Math.max(maxC, cnt[i]);
            }
        }
        return maxV + maxC;
    }
}
