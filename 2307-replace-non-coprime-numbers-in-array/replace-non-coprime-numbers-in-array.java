//arinjayjha
class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int num : nums) {
            res.add(num);
            while (res.size() > 1) {
                int a = res.get(res.size() - 2);
                int b = res.get(res.size() - 1);
                int g = gcd(a, b);
                if (g == 1) break;
                res.remove(res.size() - 1);
                res.remove(res.size() - 1);
                long lcm = (long)a / g * b;
                res.add((int)lcm);
            }
        }
        return res;
    }
    private int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}
