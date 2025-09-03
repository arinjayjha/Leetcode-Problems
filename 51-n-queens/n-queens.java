//arinjayjha
import java.util.*;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) Arrays.fill(row, '.');
        backtrack(0, n, board, res, new boolean[n], new boolean[2 * n], new boolean[2 * n]);
        return res;
    }

    private void backtrack(int row, int n, char[][] board, List<List<String>> res,
                           boolean[] cols, boolean[] d1, boolean[] d2) {
        if (row == n) {
            List<String> cur = new ArrayList<>();
            for (char[] r : board) cur.add(new String(r));
            res.add(cur);
            return;
        }
        for (int col = 0; col < n; col++) {
            int id1 = row - col + n, id2 = row + col;
            if (cols[col] || d1[id1] || d2[id2]) continue;
            cols[col] = d1[id1] = d2[id2] = true;
            board[row][col] = 'Q';
            backtrack(row + 1, n, board, res, cols, d1, d2);
            board[row][col] = '.';
            cols[col] = d1[id1] = d2[id2] = false;
        }
    }
}
