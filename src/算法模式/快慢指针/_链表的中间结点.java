package 算法模式.快慢指针;

/**
 * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。

 如果有两个中间结点，则返回第二个中间结点。

 Input: 1 -> 2 -> 3 -> 4 -> 5 -> null
 Output: 3

 Input: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null
 Output: 4

 Input: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> null
 Output: 4


 */
public class _链表的中间结点 {
    public static ListNode middleNode(ListNode head) {

        ListNode slow  = head;
        ListNode fast  = head;

        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }


        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);

        System.out.println(middleNode(head).value);
    }
}
