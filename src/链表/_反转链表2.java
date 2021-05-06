package 链表;


/**
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。
 * 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
   输出：[1,4,3,2,5]
   输入：head = [5], left = 1, right = 1
   输出：[5]
 */
public class _反转链表2 {


    public ListNode reverseBetween(ListNode head, int left, int right) {


        ListNode dummy = new ListNode(-1);

        dummy.next = head;

        ListNode pre = dummy;

        for (int i = 0; i < left-1; i++) {
            pre = pre.next;
        }

        ListNode rightNode = pre;

        for (int i = 0; i <right-left+1 ; i++) {
            rightNode = rightNode.next;
        }

        ListNode leftNode = pre.next;
        ListNode cur = rightNode.next;

        pre.next = null;
        rightNode.next = null;

        help(leftNode);

        pre.next = rightNode;
        leftNode.next = cur;


        return dummy.next;
    }



    private void  help(ListNode head){
        ListNode pre = null;
        ListNode cur = head;

        while (cur!=null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur ;
            cur = tmp;
        }
    }
}
