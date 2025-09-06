//arinjayjha
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int n = words.length;
        int i = 0;
        while (i < n) {
            int j = i + 1;
            int lineLen = words[i].length();
            while (j < n && lineLen + 1 + words[j].length() <= maxWidth) {
                lineLen += 1 + words[j].length();
                j++;
            }
            int wordCount = j - i;
            StringBuilder sb = new StringBuilder();
            if (j == n || wordCount == 1) {
                for (int k = i; k < j; k++) {
                    sb.append(words[k]);
                    if (k < j - 1) sb.append(' ');
                }
                while (sb.length() < maxWidth) sb.append(' ');
            } else {
                int totalChars = 0;
                for (int k = i; k < j; k++) totalChars += words[k].length();
                int totalSpaces = maxWidth - totalChars;
                int spaceBetween = totalSpaces / (wordCount - 1);
                int extra = totalSpaces % (wordCount - 1);
                for (int k = i; k < j; k++) {
                    sb.append(words[k]);
                    if (k < j - 1) {
                        int spaces = spaceBetween + ((k - i) < extra ? 1 : 0);
                        for (int s = 0; s < spaces; s++) sb.append(' ');
                    }
                }
            }
            res.add(sb.toString());
            i = j;
        }
        return res;
    }
}
