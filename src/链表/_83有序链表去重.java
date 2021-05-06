package 链表;


/**
 * 比如说，给你的有序单链表是：

 1 -> 1 -> 2 -> 2 -> 4

 去重后，你要返回的链表是：

 1 -> 2 -> 4
 */

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

public class _83有序链表去重 {
    public ListNode deleteDuplicates(ListNode head) {

        if(head==null) return null;

        ListNode cur = head,next=head.next;

        while (next!=null){
            if(cur.val==next.val){
                cur.next  = next.next;
            }else {
                cur = cur.next;
            }
            next = next.next;
        }




        return head;
    }

}
