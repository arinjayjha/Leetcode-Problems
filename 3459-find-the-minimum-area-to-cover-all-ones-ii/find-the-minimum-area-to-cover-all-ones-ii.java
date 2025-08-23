class Solution {
    private int m, n;
    private int[][] pref;

    public int minimumSum(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        // Build 2D prefix sum
        pref = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            int row = 0;
            for (int j = 0; j < n; j++) {
                row += grid[i][j];
                pref[i + 1][j + 1] = pref[i][j + 1] + row;
            }
        }

        int ans = area(0, 0, m - 1, n - 1); // 0 split

        // 1 split: horizontal
        for (int r = 0; r < m - 1; r++) {
            ans = Math.min(ans,
                area(0, 0, r, n - 1) +
                area(r + 1, 0, m - 1, n - 1));
        }

        // 1 split: vertical
        for (int c = 0; c < n - 1; c++) {
            ans = Math.min(ans,
                area(0, 0, m - 1, c) +
                area(0, c + 1, m - 1, n - 1));
        }

        // 2 splits: two horizontals (three bands)
        for (int r1 = 0; r1 < m - 1; r1++) {
            for (int r2 = r1 + 1; r2 < m - 1; r2++) {
                int cur =
                    area(0, 0, r1, n - 1) +
                    area(r1 + 1, 0, r2, n - 1) +
                    area(r2 + 1, 0, m - 1, n - 1);
                ans = Math.min(ans, cur);
            }
        }

        // 2 splits: two verticals (three slabs)
        for (int c1 = 0; c1 < n - 1; c1++) {
            for (int c2 = c1 + 1; c2 < n - 1; c2++) {
                int cur =
                    area(0, 0, m - 1, c1) +
                    area(0, c1 + 1, m - 1, c2) +
                    area(0, c2 + 1, m - 1, n - 1);
                ans = Math.min(ans, cur);
            }
        }

        // 2 splits: L/T shapes
        // horizontal then vertical on TOP
        for (int r = 0; r < m - 1; r++) {
            for (int c = 0; c < n - 1; c++) {
                int cur =
                    area(0, 0, r, c) +
                    area(0, c + 1, r, n - 1) +
                    area(r + 1, 0, m - 1, n - 1);
                ans = Math.min(ans, cur);
            }
        }
        // horizontal then vertical on BOTTOM
        for (int r = 0; r < m - 1; r++) {
            for (int c = 0; c < n - 1; c++) {
                int cur =
                    area(0, 0, r, n - 1) +
                    area(r + 1, 0, m - 1, c) +
                    area(r + 1, c + 1, m - 1, n - 1);
                ans = Math.min(ans, cur);
            }
        }
        // vertical then horizontal on LEFT
        for (int c = 0; c < n - 1; c++) {
            for (int r = 0; r < m - 1; r++) {
                int cur =
                    area(0, 0, r, c) +
                    area(r + 1, 0, m - 1, c) +
                    area(0, c + 1, m - 1, n - 1);
                ans = Math.min(ans, cur);
            }
        }
        // vertical then horizontal on RIGHT
        for (int c = 0; c < n - 1; c++) {
            for (int r = 0; r < m - 1; r++) {
                int cur =
                    area(0, 0, m - 1, c) +
                    area(0, c + 1, r, n - 1) +
                    area(r + 1, c + 1, m - 1, n - 1);
                ans = Math.min(ans, cur);
            }
        }

        return ans;
    }

    // Sum of submatrix [x1..x2] x [y1..y2], inclusive
    private int sum(int x1, int y1, int x2, int y2) {
        if (x1 > x2 || y1 > y2) return 0;
        return pref[x2 + 1][y2 + 1] - pref[x1][y2 + 1] - pref[x2 + 1][y1] + pref[x1][y1];
    }

    // Area of tightest rectangle covering all 1s in the submatrix
    // Uses prefix sums to scan rows/cols only (O(m + n) per call)
    private int area(int x1, int y1, int x2, int y2) {
        if (x1 > x2 || y1 > y2) return 0;
        if (sum(x1, y1, x2, y2) == 0) return 0;

        int top = -1, bottom = -1, left = -1, right = -1;

        for (int i = x1; i <= x2; i++) {
            if (sum(i, y1, i, y2) > 0) { top = i; break; }
        }
        for (int i = x2; i >= x1; i--) {
            if (sum(i, y1, i, y2) > 0) { bottom = i; break; }
        }
        for (int j = y1; j <= y2; j++) {
            if (sum(x1, j, x2, j) > 0) { left = j; break; }
        }
        for (int j = y2; j >= y1; j--) {
            if (sum(x1, j, x2, j) > 0) { right = j; break; }
        }
        return (bottom - top + 1) * (right - left + 1);
    }
}
