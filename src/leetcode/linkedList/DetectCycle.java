package leetcode.linkedList;

public class DetectCycle {
    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
            next = null;
        }
    }
    public ListNode detectCycle(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;

        ListNode lastVisit = head;
        while(slow != null && fast != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                lastVisit = slow;
            }
        }
        ListNode currenthead = head;
        while(currenthead != lastVisit){
            lastVisit = lastVisit.next;
            currenthead = currenthead.next;

        }
        return lastVisit;
    }
}
