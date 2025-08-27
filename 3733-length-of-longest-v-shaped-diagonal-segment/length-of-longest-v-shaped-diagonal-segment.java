class Solution {
    public int lenOfVDiagonal(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        // 5D memoization array: position i, j, turned flag, hashNum (based on expected next), direction
        Integer[][][][][] mem = new Integer[m][n][2][2][4];
        int ans = 0;
        
        // Try starting from every '1' cell
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    for (int dir = 0; dir < 4; dir++) {
                        ans = Math.max(ans, 1 + dfs(grid, i + kDirs[dir][0], j + kDirs[dir][1],
                                                    false, 2, dir, mem));
                    }
                }
            }
        }
        return ans;
    }

    // Directions: ↗, ↘, ↙, ↖
    private static final int[][] kDirs = {{-1, 1}, {1, 1}, {1, -1}, {-1, -1}};
    
    private int dfs(int[][] grid, int i, int j, boolean turned, int num, int dir,
                    Integer[][][][][] mem) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != num) return 0;

        int hashNum = Math.max(0, num - 1);
        if (mem[i][j][turned ? 1 : 0][hashNum][dir] != null) {
            return mem[i][j][turned ? 1 : 0][hashNum][dir];
        }

        int nextNum = (num == 2 ? 0 : 2);
        int[] d = kDirs[dir];
        int res = 1 + dfs(grid, i + d[0], j + d[1], turned, nextNum, dir, mem);

        // If not turned yet, attempt a clockwise 90° turn
        if (!turned) {
            int nextDir = (dir + 1) % 4;
            int[] nd = kDirs[nextDir];
            res = Math.max(res, 1 + dfs(grid, i + nd[0], j + nd[1], true, nextNum, nextDir, mem));
        }

        mem[i][j][turned ? 1 : 0][hashNum][dir] = res;
        return res;
    }
}
