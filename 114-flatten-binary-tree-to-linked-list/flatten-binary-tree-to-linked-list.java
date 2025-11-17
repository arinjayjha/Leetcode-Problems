//arinjayjha
class Solution {
    public void flatten(TreeNode root) {
        flattenTree(root);
    }

    private TreeNode flattenTree(TreeNode node) {
        if (node == null) return null;

        // Flatten left and right subtrees
        TreeNode leftTail = flattenTree(node.left);
        TreeNode rightTail = flattenTree(node.right);

        // If there is a left subtree, we insert it between node and node.right
        if (leftTail != null) {
            leftTail.right = node.right;
            node.right = node.left;
            node.left = null;
        }

        // Return the last node (tail)
        if (rightTail != null) return rightTail;
        if (leftTail != null) return leftTail;
        return node;
    }
}
