//arinjayjha
import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || words == null || words.length == 0) return res;

        int n = s.length(), m = words[0].length(), k = words.length, window = m * k;
        if (n < window) return res;

        Map<String, Integer> need = new HashMap<>();
        for (String w : words) need.put(w, need.getOrDefault(w, 0) + 1);

        for (int offset = 0; offset < m; offset++) {
            int left = offset, matched = 0;
            Map<String, Integer> seen = new HashMap<>();
            for (int right = offset; right + m <= n; right += m) {
                String w = s.substring(right, right + m);
                if (!need.containsKey(w)) {
                    seen.clear();
                    matched = 0;
                    left = right + m;
                    continue;
                }
                seen.put(w, seen.getOrDefault(w, 0) + 1);
                matched++;

                while (seen.get(w) > need.get(w)) {
                    String lw = s.substring(left, left + m);
                    seen.put(lw, seen.get(lw) - 1);
                    left += m;
                    matched--;
                }

                if (matched == k) {
                    res.add(left);
                    String lw = s.substring(left, left + m);
                    seen.put(lw, seen.get(lw) - 1);
                    left += m;
                    matched--;
                }
            }
        }
        return res;
    }
}
