//arinjayjha
class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int gcdAll = nums[0];
        for (int x : nums) gcdAll = gcd(gcdAll, x);
        if (gcdAll != 1) return -1; // impossible if overall gcd > 1

        int ones = 0;
        for (int x : nums) if (x == 1) ones++;
        if (ones > 0) return n - ones; // make all equal to 1 using existing ones

        // Find shortest subarray with gcd = 1
        int minLen = n;
        for (int i = 0; i < n; i++) {
            int g = nums[i];
            for (int j = i + 1; j < n; j++) {
                g = gcd(g, nums[j]);
                if (g == 1) {
                    minLen = Math.min(minLen, j - i + 1);
                    break;
                }
            }
        }
        // Need (minLen - 1) operations to create a single 1, then (n - 1) to spread it
        return (minLen - 1) + (n - 1);
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}
