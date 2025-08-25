class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length == 0) return new int[0];
        int m = mat.length, n = mat[0].length;
        int[] ans = new int[m * n];

        int r = 0, c = 0;
        for (int i = 0; i < ans.length; i++) {
            ans[i] = mat[r][c];

            // moving up-right
            if ((r + c) % 2 == 0) {
                if (c == n - 1) r++;         // hit right wall
                else if (r == 0) c++;        // hit top wall
                else { r--; c++; }           // normal move
            } 
            // moving down-left
            else {
                if (r == m - 1) c++;         // hit bottom wall
                else if (c == 0) r++;        // hit left wall
                else { r++; c--; }           // normal move
            }
        }
        return ans;
    }
}
