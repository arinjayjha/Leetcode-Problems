//arinjayjha
class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        int len = word.length();
        boolean[][] vis = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j, 0, vis)) return true;
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, String word, int i, int j, int idx, boolean[][] vis) {
        if (idx == word.length()) return true;
        int m = board.length, n = board[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n) return false;
        if (vis[i][j] || board[i][j] != word.charAt(idx)) return false;
        vis[i][j] = true;
        boolean found = dfs(board, word, i + 1, j, idx + 1, vis)
                     || dfs(board, word, i - 1, j, idx + 1, vis)
                     || dfs(board, word, i, j + 1, idx + 1, vis)
                     || dfs(board, word, i, j - 1, idx + 1, vis);
        vis[i][j] = false;
        return found;
    }
}
