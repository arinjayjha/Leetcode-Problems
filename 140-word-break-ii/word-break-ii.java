class Solution {

    private Set<String> dictionary;
    private Map<Integer, List<String>> memo;

    public List<String> wordBreak(String s, List<String> wordDict) {

        dictionary = new HashSet<>(wordDict);
        memo = new HashMap<>();

        return dfs(s, 0);
    }

    private List<String> dfs(String s, int start) {

        // Already calculated
        if (memo.containsKey(start)) {
            return memo.get(start);
        }

        List<String> result = new ArrayList<>();

        // Reached the end
        if (start == s.length()) {
            result.add("");
            return result;
        }

        // Try every possible word
        for (int end = start + 1; end <= s.length(); end++) {

            String word = s.substring(start, end);

            // If this substring is a dictionary word
            if (dictionary.contains(word)) {

                // Solve the remaining part
                List<String> remaining = dfs(s, end);

                for (String sentence : remaining) {

                    if (sentence.isEmpty()) {
                        result.add(word);
                    } else {
                        result.add(word + " " + sentence);
                    }
                }
            }
        }

        // Save result for this starting index
        memo.put(start, result);

        return result;
    }
}