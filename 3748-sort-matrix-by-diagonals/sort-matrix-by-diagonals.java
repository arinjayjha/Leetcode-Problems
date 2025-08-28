//arinjayjha
import java.util.*;

class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        Map<Integer, List<Integer>> diag = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int key = i - j;
                diag.computeIfAbsent(key, k -> new ArrayList<>()).add(grid[i][j]);
            }
        }

        Map<Integer, Queue<Integer>> ready = new HashMap<>();
        for (Map.Entry<Integer, List<Integer>> e : diag.entrySet()) {
            int key = e.getKey();
            List<Integer> list = e.getValue();
            if (key >= 0) list.sort(Comparator.reverseOrder());
            else Collections.sort(list);
            ready.put(key, new ArrayDeque<>(list));
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = ready.get(i - j).poll();
            }
        }
        return grid;
    }
}
