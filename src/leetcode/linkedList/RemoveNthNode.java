package leetcode.linkedList;

import leetcode.linkedList.ListNode;

public class RemoveNthNode {


    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);

        ListNode first = dummy;
        ListNode second = dummy;

        dummy.next = head; // Linking the given head

        // Advances first pointer so that the gap between first and second is n nodes apart
        for(int i=1; i<= n+1; i++){
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while(first !=null){
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;

        return dummy.next;
    }
}
