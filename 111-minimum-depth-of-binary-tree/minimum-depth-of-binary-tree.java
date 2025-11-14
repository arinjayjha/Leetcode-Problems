//arinjayjha
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;

        int left = root.left == null ? Integer.MAX_VALUE : minDepth(root.left);
        int right = root.right == null ? Integer.MAX_VALUE : minDepth(root.right);

        return 1 + Math.min(left, right);
    }
}
