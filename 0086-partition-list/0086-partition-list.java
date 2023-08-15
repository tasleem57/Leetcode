class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode slist = new ListNode();
        ListNode blist = new ListNode();
        ListNode small = slist;
        ListNode big = blist;

        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                big.next = head;
                big = big.next;
            }

            head = head.next;
        }

        small.next = blist.next;
        big.next = null;

        return slist.next;        
    }
}