//arinjayjha
class Solution {
    public Node connect(Node root) {
        if (root == null) return null;

        Node curr = root;     // current level
        Node dummy = new Node(0); // dummy head for next level
        Node tail = dummy;    // tail pointer to build next-level links

        while (curr != null) {
            while (curr != null) {
                if (curr.left != null) {
                    tail.next = curr.left;
                    tail = tail.next;
                }
                if (curr.right != null) {
                    tail.next = curr.right;
                    tail = tail.next;
                }
                curr = curr.next; // move on same level
            }

            curr = dummy.next; // move to next level
            dummy.next = null; // reset dummy
            tail = dummy;      // reset tail
        }

        return root;
    }
}
