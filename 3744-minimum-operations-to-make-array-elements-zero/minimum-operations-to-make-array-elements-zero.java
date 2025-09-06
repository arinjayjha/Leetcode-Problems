//arinjayjha
class Solution {
    public long minOperations(int[][] queries) {
        long ans = 0;
        for (int[] query : queries) {
            final int l = query[0];
            final int r = query[1];
            ans += (getOperations(r) - getOperations(l - 1) + 1) / 2;
        }
        return ans;
    }

    // Returns the number of operations required for [1, n].
    private long getOperations(int n) {
        if (n <= 0) return 0;
        long res = 0;
        int ops = 0;
        for (long powerOfFour = 1; powerOfFour <= n; powerOfFour *= 4) {
            final int L = (int) powerOfFour;
            final int R = (int) Math.min((long) Integer.MAX_VALUE, Math.min(n, powerOfFour * 4 - 1));
            res += (long) (R - L + 1) * ++ops;
        }
        return res;
    }
}
