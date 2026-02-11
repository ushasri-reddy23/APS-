class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null || k == 1) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;

        while (true) {

            // check if k nodes exist
            ListNode temp = prev;
            for (int i = 0; i < k; i++) {
                temp = temp.next;
                if (temp == null) {
                    return dummy.next;
                }
            }

            // reverse k nodes
            ListNode curr = prev.next;
            ListNode next = curr.next;

            for (int i = 1; i < k; i++) {
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = curr.next;
            }

            prev = curr;
        }
    }
}
