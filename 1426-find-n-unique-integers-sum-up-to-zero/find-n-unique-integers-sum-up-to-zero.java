//arinjayjha
class Solution {
    public int[] sumZero(int n) {
        int[] res = new int[n];
        int i = 0;
        int val = 1;
        while (i + 1 < n) {
            res[i++] = val;
            res[i++] = -val;
            val++;
        }
        if (i < n) res[i] = 0;
        return res;
    }
}
