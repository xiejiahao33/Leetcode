package 算法模式.快慢指针;


class  ListNode{
    int value = 0;
    ListNode next;

    ListNode(int value){
        this.value = value;
    }
}
public class _链表是否有环 {

    public static boolean hasCycle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow) return true;
        }


        return false;
    }



    public static void main(String[] args) {
        ListNode head =new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        System.out.println("LinkedList has cycle:" + _链表是否有环.hasCycle(head));

        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList has cycle:" + _链表是否有环.hasCycle(head));

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList has cycle:" + _链表是否有环.hasCycle(head));


    }

}
