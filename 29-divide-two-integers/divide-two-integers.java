//arinjayjha
class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        long a = Math.abs((long) dividend), b = Math.abs((long) divisor), res = 0;
        while (a >= b) {
            long temp = b, multiple = 1;
            while (a >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }
            a -= temp;
            res += multiple;
        }
        if ((dividend > 0) ^ (divisor > 0)) res = -res;
        return (int) res;
    }
}
