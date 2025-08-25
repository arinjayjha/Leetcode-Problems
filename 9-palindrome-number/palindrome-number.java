class Solution {
    public boolean isPalindrome(int x) {
        // Negative numbers and multiples of 10 (except 0) are not palindrome
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;

        int reversedHalf = 0;
        // Build the reversed half of the number
        while (x > reversedHalf) {
            reversedHalf = reversedHalf * 10 + x % 10;
            x /= 10;
        }

        // For even length: x == reversedHalf
        // For odd length: x == reversedHalf / 10 (middle digit ignored)
        return x == reversedHalf || x == reversedHalf / 10;
    }
}
