//arinjayjha
class Solution {
    public int findClosest(int x, int y, int z) {
        int dx = Math.abs(x - z), dy = Math.abs(y - z);
        if (dx == dy) return 0;
        return dx < dy ? 1 : 2;
    }
}
