//arinjayjha
class Solution {
    public boolean doesAliceWin(String s) {
        for (char c : s.toCharArray()) {
            if ("aeiouAEIOU".indexOf(c) >= 0) return true;
        }
        return false;
    }
}
