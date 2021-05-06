package 牛客;


class ListNode {
   int val;
  ListNode next = null;
    ListNode(int x) {
        val = x;
    }
 }

public class NC33有序链表合并 {

    public ListNode mergeTwoLists (ListNode l1, ListNode l2) {
        // write code here
        ListNode dummy = new ListNode(0), p = dummy;

        while (l1!=null &&  l2 !=null) {
            if(l1.val<l2.val){
                p.next = l1;
                l1 = l1.next;
            }else {
                p.next = l2;
                l2 = l2.next;
            }

            p = p.next;
        }
        if(l1!=null)  p.next = l1;
        if(l2!=null)  p.next = l2;
        return dummy.next;
    }
}
