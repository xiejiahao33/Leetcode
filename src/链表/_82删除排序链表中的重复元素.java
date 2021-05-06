package 链表;


/**
 * 这个题目说的是，给你一个单链表，这个单链表节点上的数字是有序的。
 * 对于出现多次的数字，你要把它们全删掉，留下只出现一次的节点，最后返回处理后的单链表。
 * 比如说，给你的有序单链表是：

 1 -> 1 -> 2 -> 4

 1 出现了多次，删掉它后，你要返回的链表是：

 2 -> 4
 */
public class _82删除排序链表中的重复元素 {
    public ListNode deleteDuplicates(ListNode head) {

        if (head==null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy,cur = dummy.next;
        while (cur!=null){
            while (cur.next!=null && cur.val==cur.next.val) cur = cur.next;

            // update prev
            if(pre.next!=cur) pre.next = cur.next;
            else pre = pre.next;


            //update cur
            cur =pre.next ;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2 =  l4;
        System.out.println(l1.next.val);
        System.out.println(l2.val);
        System.out.println(l1.next.hashCode());
        System.out.println(l2.hashCode());
        System.out.println(l4.hashCode());
    }
}
