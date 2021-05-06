package 链表;


/**
 * 比如说给你的单链表是：
 1 -> 2 -> 3 -> 4 -> 5 -> null
 你要返回的反转后的链表是：
 5 -> 4 -> 3 -> 2 -> 1 -> null
 */
public class _206反转链表 {
    public ListNode reverseList(ListNode head) {

        ListNode cur = head,pre = null;

        while (cur!=null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur= next;
        }



        return pre;
    }
}
