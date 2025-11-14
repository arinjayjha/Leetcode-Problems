//arinjayjha
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        // If it's a leaf node, check if the sum matches
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        // Recur on left and right subtrees with updated sum
        int remaining = targetSum - root.val;
        return hasPathSum(root.left, remaining) || hasPathSum(root.right, remaining);
    }
}
