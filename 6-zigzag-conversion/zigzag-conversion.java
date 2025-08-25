class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) return s;

        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) rows[i] = new StringBuilder();

        int r = 0, dir = 1; // +1 down, -1 up
        for (char c : s.toCharArray()) {
            rows[r].append(c);
            if (r == 0) dir = 1;
            else if (r == numRows - 1) dir = -1;
            r += dir;
        }

        StringBuilder ans = new StringBuilder(s.length());
        for (StringBuilder row : rows) ans.append(row);
        return ans.toString();
    }
}
