package solution;

import data.ListNode;
import util.GenDataUtils;
import util.PrintUtils;


public class Problem25 {

    public static void main(String[] args) {
        ListNode head = GenDataUtils.genList(10);
        PrintUtils.printListNode(head);
        PrintUtils.printListNode(reverseKGroup(head,2));
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode first = head;
        while(head!=null){
            count++;
            if(count==k){
                break;
            }
            head = head.next;
        }


        if(count==k){
            // start reverse
            int idx = 0;
            ListNode head_0 = first;
            ListNode prev = first;
            ListNode cur = first.next;
            while(idx < count - 1){
                ListNode tmp = cur.next;
                cur.next = prev;
                prev = cur;
                cur = tmp;
                idx++;
            }
            head_0.next = reverseKGroup(cur,k);
            return prev;
        }else {
            return first;
        }
    }

}
