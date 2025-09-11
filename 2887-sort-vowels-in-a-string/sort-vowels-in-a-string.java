//arinjayjha
class Solution {
    public String sortVowels(String s) {
        char[] arr = s.toCharArray();
        List<Character> vowels = new ArrayList<>();
        for (char c : arr) {
            if (isVowel(c)) vowels.add(c);
        }
        vowels.sort((a, b) -> a - b);
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (isVowel(arr[i])) arr[i] = vowels.get(idx++);
        }
        return new String(arr);
    }
    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}
