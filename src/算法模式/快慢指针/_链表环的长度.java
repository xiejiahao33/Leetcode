package 算法模式.快慢指针;

public class _链表环的长度 {
    public static int findCycleLength(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow) return calculateLength(slow);
        }
        return 0;
    }

    private static int calculateLength(ListNode slow){
        ListNode current = slow;
        int cycleLrngth= 0;
        do{
            current = current.next;
            cycleLrngth++;
        }while (current!=slow);

        return cycleLrngth;
    }



    public static void main(String[] args) {
        ListNode head =new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        System.out.println("LinkedList cycle length:" + _链表环的长度.findCycleLength(head));

        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList cycle length:" + _链表环的长度.findCycleLength(head));

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList cycle length:" + _链表环的长度.findCycleLength(head));


    }
}
