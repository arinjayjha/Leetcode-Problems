class Solution {
    public int minMoves(String[] classroom, int energy) {

        int m = classroom.length;
        int n = classroom[0].length();

        // litter[i][j] = bit number of litter at this cell
        int[][] litter = new int[m][n];

        int startX = 0;
        int startY = 0;
        int count = 0;

        // Find start and number every litter cell
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                char c = classroom[i].charAt(j);

                if (c == 'S') {
                    startX = i;
                    startY = j;
                } 
                else if (c == 'L') {
                    litter[i][j] = count++;
                }
            }
        }

        // No litter
        if (count == 0) {
            return 0;
        }

        int totalMasks = 1 << count;
        int allCollected = totalMasks - 1;

        /*
         * visited[row][col][energy][mask]
         */
        boolean[][][][] visited =
            new boolean[m][n][energy + 1][totalMasks];

        /*
         * State:
         * [row, col, remainingEnergy, mask]
         */
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[] {
            startX,
            startY,
            energy,
            0
        });

        visited[startX][startY][energy][0] = true;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int moves = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            // Process one BFS level
            while (size-- > 0) {

                int[] cur = queue.poll();

                int x = cur[0];
                int y = cur[1];
                int currEnergy = cur[2];
                int mask = cur[3];

                // All litter collected
                if (mask == allCollected) {
                    return moves;
                }

                // Cannot move without energy
                if (currEnergy == 0) {
                    continue;
                }

                for (int d = 0; d < 4; d++) {

                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    // Outside grid
                    if (nx < 0 || nx >= m ||
                        ny < 0 || ny >= n) {
                        continue;
                    }

                    // Obstacle
                    if (classroom[nx].charAt(ny) == 'X') {
                        continue;
                    }

                    char cell = classroom[nx].charAt(ny);

                    // Moving normally costs 1 energy
                    int newEnergy = currEnergy - 1;

                    // R resets energy to maximum
                    if (cell == 'R') {
                        newEnergy = energy;
                    }

                    // Collect litter
                    int newMask = mask;

                    if (cell == 'L') {
                        int bit = litter[nx][ny];
                        newMask |= (1 << bit);
                    }

                    if (!visited[nx][ny][newEnergy][newMask]) {

                        visited[nx][ny][newEnergy][newMask] = true;

                        queue.offer(new int[] {
                            nx,
                            ny,
                            newEnergy,
                            newMask
                        });
                    }
                }
            }

            moves++;
        }

        return -1;
    }
}