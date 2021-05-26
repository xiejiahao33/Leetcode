package 算法模式.快慢指针;

/**
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…

 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

 Input: 2 -> 4 -> 6 -> 8 -> 10 -> 12 -> null
 Output: 2 -> 12 -> 4 -> 10 -> 6 -> 8 -> null

 Input: 2 -> 4 -> 6 -> 8 -> 10 -> null
 Output: 2 -> 10 -> 4 -> 8 -> 6 -> null

 */
public class _重排链表 {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode head2 = slow.next;
        slow.next = null;
        ListNode headSecondHalf = reverse(head2);

        ListNode head1 = head;
        mergeList(head1,headSecondHalf);
    }



    private static ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode cur = head;
        while (cur!=null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    private void mergeList(ListNode head1, ListNode head2){
        ListNode next1 = null;
        ListNode next2 = null;
        while (head1!=null && head2!=null){
            next1 = head1.next;
            next2 = head2.next;

            head1.next = head2;
            head1 = next1;

            head2.next = head1;
            head2 = next2;
        }
    }
}
