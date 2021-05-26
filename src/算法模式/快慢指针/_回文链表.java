package 算法模式.快慢指针;


import java.util.List;
import java.util.Stack;

/**
 * 请判断一个链表是否为回文链表。
 * 输入: 1->2
 输出: false

 输入: 1->2->2->1
 输出: true

 */
public class _回文链表 {
    public boolean isPalindrome(ListNode head) {

        if (head==null || head.next==null)
            return true;

        ListNode slow = head;
        ListNode fast = head;

        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode headSecondHalf = reverse(slow);

        ListNode p1 = head;
        ListNode p2 = headSecondHalf;

        while (p1!=null && p2!=null){
            if(p1.value !=p2.value){
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        reverse(headSecondHalf);

        return true;
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

    public boolean  isPalindromeUsingStack(ListNode head){
        Stack<Integer> s= new Stack<>();
        for (ListNode p = head; p!=null ;p = p.next) {
            s.push(p.value);
        }

        for (ListNode p = head; p!=null ;p = p.next) {
            if(s.pop()!=p.value) return false;
        }
        return true;
    }
}
