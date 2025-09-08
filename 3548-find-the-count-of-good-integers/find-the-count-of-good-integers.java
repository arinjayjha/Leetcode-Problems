//arinjayjha
class Solution {
    public long countGoodIntegers(int n, int k) {
        int half = (n + 1) / 2;
        int minHalf = (int) Math.pow(10, half - 1);
        int maxHalf = (int) Math.pow(10, half);
        java.util.Set<String> seen = new java.util.HashSet<>();
        long[] fact = new long[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) fact[i] = fact[i - 1] * i;
        long ans = 0;
        for (int num = minHalf; num < maxHalf; num++) {
            String first = String.valueOf(num);
            String second = new StringBuilder(first).reverse().toString();
            String pal = first + second.substring(n % 2);
            long val = Long.parseLong(pal);
            if (val % k != 0) continue;
            char[] chars = pal.toCharArray();
            java.util.Arrays.sort(chars);
            String sig = new String(chars);
            if (seen.contains(sig)) continue;
            seen.add(sig);
            int[] cnt = new int[10];
            for (char c : pal.toCharArray()) cnt[c - '0']++;
            long permsNoLeadingZero = 0;
            for (int d = 1; d <= 9; d++) {
                if (cnt[d] == 0) continue;
                cnt[d]--;
                long perm = fact[n - 1];
                for (int t = 0; t <= 9; t++) perm /= fact[cnt[t]];
                permsNoLeadingZero += perm;
                cnt[d]++;
            }
            ans += permsNoLeadingZero;
        }
        return ans;
    }
}
