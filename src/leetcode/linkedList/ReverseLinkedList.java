package leetcode.linkedList;

import leetcode.linkedList.ListNode;

public class ReverseLinkedList {
  /*  This seems to be a classic question that I have received multiple times in real interviews.
  Typically, it is asked as a phone screen or initial screening questions.
  Regardless, it can seem a bit tricky but it really doesn't take a whole lot of code to accomplish this.

    My solution is as follows:*/

    public ListNode reverseList(ListNode head) {
        // is there something to reverse?
        if (head != null && head.next != null)
        {
            ListNode pivot = head;
            ListNode frontier = null;
            while (pivot != null && pivot.next != null)
            {
                frontier = pivot.next;
                pivot.next = pivot.next.next;
                frontier.next = head;
                head = frontier;
            }
        }

        return head;
    }
    /*This is a very quick, O(n) reversal that times at 0ms in Leetcode OJ.
    The trick is to think of the first element as the new last item in the list.
    After reversing, this must be true.
    Then, we just move the element that pivot .next points to (the initial head of the list)
    and we move it to become the new head.
    This essentially grows the list backwards until the initial pivot no longer has anything to move.

    For example; if we have a list [1, 2, 3, 4], the algorithm will do the following:

    Set pivot to 1, set frontier to 2, keep head at 1
    We see that pivot still has items after it, so set pivots .next to .next.next,
    and move the pivot to be set to the current head
    Now move the head back to point to the new head, which is the frontier node we just set
    Now reset frontier to pivots .next and repeat.
    So with each iteration of the loop the list becomes:

            [1, 2, 3, 4]
            [2, 1, 3, 4]
            [3, 2, 1, 4]
            [4, 3, 2, 1]
    Then we return the new final head which points to 4.*/
}
