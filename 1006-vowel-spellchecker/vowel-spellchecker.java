//arinjayjha
import java.util.*;

public class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exact = new HashSet<>();
        Map<String, String> lower = new HashMap<>();
        Map<String, String> devowel = new HashMap<>();
        for (String w : wordlist) {
            exact.add(w);
            String wl = w.toLowerCase();
            lower.putIfAbsent(wl, w);
            String dw = devowelize(wl);
            devowel.putIfAbsent(dw, w);
        }
        String[] ans = new String[queries.length];
        for (int i = 0; i < queries.length; ++i) {
            String q = queries[i];
            if (exact.contains(q)) {
                ans[i] = q;
                continue;
            }
            String ql = q.toLowerCase();
            if (lower.containsKey(ql)) {
                ans[i] = lower.get(ql);
                continue;
            }
            String dql = devowelize(ql);
            if (devowel.containsKey(dql)) {
                ans[i] = devowel.get(dql);
            } else {
                ans[i] = "";
            }
        }
        return ans;
    }

    private String devowelize(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c=='a' || c=='e' || c=='i' || c=='o' || c=='u') sb.append('*');
            else sb.append(c);
        }
        return sb.toString();
    }
}
