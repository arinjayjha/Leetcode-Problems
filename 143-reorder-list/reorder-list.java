class Solution {
    public void reorderList(ListNode head) {

        if (head == null || head.next == null) {
            return;
        }

        // 1. Find the middle
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. Separate the second half
        ListNode second = slow.next;
        slow.next = null;

        // 3. Reverse the second half
        ListNode prev = null;

        while (second != null) {
            ListNode next = second.next;

            second.next = prev;
            prev = second;
            second = next;
        }

        // prev = head of reversed second half
        second = prev;

        // 4. Merge both halves
        ListNode first = head;

        while (second != null) {
            ListNode firstNext = first.next;
            ListNode secondNext = second.next;

            first.next = second;
            second.next = firstNext;

            first = firstNext;
            second = secondNext;
        }
    }
}