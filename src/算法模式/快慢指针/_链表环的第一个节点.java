package 算法模式.快慢指针;

public class _链表环的第一个节点 {


    public static ListNode detectCycle(ListNode head) {

        int cycleLength = 0;
        ListNode slow = head;
        ListNode fast = head;

        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow) {
                cycleLength =calculateLength(slow);
                break;
            }
        }

        return findStart(head,cycleLength);
    }


    private static ListNode findStart(ListNode head,int cycleLength){
        if(cycleLength==0) return null;
        ListNode p1 = head,p2 = head;
        while (cycleLength>0){
            p1 = p1.next;
            cycleLength--;
        }

        while (p1!=p2){
            p1=p1.next;
            p2=p2.next;
        }
        return p2;
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

        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList cycle length:" + _链表环的第一个节点.detectCycle(head).value);

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList cycle length:" + _链表环的第一个节点.detectCycle(head).value);

        head.next.next.next.next.next.next = head;
        System.out.println("LinkedList cycle length:" + _链表环的第一个节点.detectCycle(head).value);

    }


}
