class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        long bestD2 = -1;   
        int bestArea = 0;

        for (int[] rect : dimensions) {
            long w = rect[0], h = rect[1];
            long d2 = w * w + h * h;     
            int area = (int) (w * h);    

            if (d2 > bestD2 || (d2 == bestD2 && area > bestArea)) {
                bestD2 = d2;
                bestArea = area;
            }
        }
        return bestArea;
    }
}
