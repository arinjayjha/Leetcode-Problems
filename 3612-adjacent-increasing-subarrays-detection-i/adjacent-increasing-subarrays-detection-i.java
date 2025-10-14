//arinjayjha
import java.util.*;

class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> numsList, int k) {
        int n = numsList.size();
        if (2 * k > n) return false;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = numsList.get(i);

        int[] inc = new int[n];
        inc[0] = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) inc[i] = inc[i - 1] + 1;
            else inc[i] = 1;
        }

        for (int i = 0; i + 2 * k - 1 < n; i++) {
            if (inc[i + k - 1] >= k && inc[i + 2 * k - 1] >= k) return true;
        }
        return false;
    }
}
