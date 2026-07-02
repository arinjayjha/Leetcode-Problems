class Solution {
public:
    bool findSafeWalk(vector<vector<int>>& grid, int health) {
        int m = grid.size(), n = grid[0].size();

        vector<vector<int>> best(m, vector<int>(n, -1));

        priority_queue<tuple<int,int,int>> pq;

        int start = health - grid[0][0];
        if (start <= 0) return false;

        best[0][0] = start;
        pq.push({start, 0, 0});

        vector<int> dr = {-1, 1, 0, 0};
        vector<int> dc = {0, 0, -1, 1};

        while (!pq.empty()) {
            auto [rem, r, c] = pq.top();
            pq.pop();

            if (r == m - 1 && c == n - 1)
                return true;

            if (rem < best[r][c]) continue;

            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];

                if (nr < 0 || nr >= m || nc < 0 || nc >= n)
                    continue;

                int nxt = rem - grid[nr][nc];

                if (nxt > 0 && nxt > best[nr][nc]) {
                    best[nr][nc] = nxt;
                    pq.push({nxt, nr, nc});
                }
            }
        }

        return false;
    }
};