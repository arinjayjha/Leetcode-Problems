//arinjayjha
class Solution {
    private int count = 0;

    public int totalNQueens(int n) {
        backtrack(0, n, new boolean[n], new boolean[2 * n], new boolean[2 * n]);
        return count;
    }

    private void backtrack(int row, int n, boolean[] cols, boolean[] d1, boolean[] d2) {
        if (row == n) {
            count++;
            return;
        }
        for (int col = 0; col < n; col++) {
            int id1 = row - col + n, id2 = row + col;
            if (cols[col] || d1[id1] || d2[id2]) continue;
            cols[col] = d1[id1] = d2[id2] = true;
            backtrack(row + 1, n, cols, d1, d2);
            cols[col] = d1[id1] = d2[id2] = false;
        }
    }
}
