class Solution {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int current) {
        if (root == null) {
            return 0;
        }

        // Build the number
        current = current * 10 + root.val;

        // If leaf, return the complete number
        if (root.left == null && root.right == null) {
            return current;
        }

        // Sum of left and right paths
        return dfs(root.left, current) + dfs(root.right, current);
    }
}