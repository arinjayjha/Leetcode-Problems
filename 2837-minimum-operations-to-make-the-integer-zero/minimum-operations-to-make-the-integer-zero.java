//arinjayjha
class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        for (long ops = 0; ops <= 60; ops++) {
            long target = (long) num1 - ops * (long) num2;
            if (target < 0) continue;
            if (Long.bitCount(target) <= ops && ops <= target) return (int) ops;
        }
        return -1;
    }
}
