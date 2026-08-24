class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;

        for (int bit = 0; bit < 32; bit++) {
            int count = 0;

            for (int num : nums) {
                if ((num & (1 << bit)) != 0) {
                    count++;
                }
            }

            // If count is not divisible by 3,
            // this bit belongs to the single number.
            if (count % 3 != 0) {
                result |= (1 << bit);
            }
        }

        return result;
    }
}