package solution.problem;

import data.ListNode;
import util.GenDataUtils;
import util.PrintUtils;

public class Problem19 {

    public static void main(String[] args) {
        ListNode head = GenDataUtils.genList("[1,2,3,4,5]");
        PrintUtils.printListNode(head);
        PrintUtils.printListNode(removeNthFromEnd(head,2));
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        int cnt = 0;
        while (cnt<n){
            fast = fast.next;
            cnt++;
        }
        if(fast==null){
            return head.next;
        }

        while (fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return head;
    }
}
