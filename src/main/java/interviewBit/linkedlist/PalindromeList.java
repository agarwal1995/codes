package interviewBit.linkedlist;

/**
 * Given a singly linked list A, determine if it's a palindrome. Return 1 or 0, denoting if it's a palindrome or not, respectively.
 * @author raag
 */
public class PalindromeList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode tempHead = head;
      //  tempHead.next = new ListNode(1);
        //tempHead = tempHead.next;
        //tempHead.next = new ListNode(1);

        System.out.println(new PalindromeList().lPalin(head));
    }

    public int lPalin(ListNode A) {
        // find middle of linked list
        ListNode middle = getMiddle(A);
        // reverse 2nd part of the middle
        ListNode secondPartReverse = reverseList(middle.next);
        middle.next = null;
        // compare the 2 list

        while (secondPartReverse!=null) {
            if(A.val!=secondPartReverse.val) {
                return 0;
            }
            A = A.next;
            secondPartReverse = secondPartReverse.next;
        }
        return 1;
    }

    public ListNode getMiddle(ListNode node) {
        ListNode slow = node;
        ListNode fast = node;
        while (fast!=null) {
            fast=fast.next;
            if(fast!=null && fast.next!=null) {
                slow = slow.next;
                fast = fast.next;
            }
        }
        return slow;
    }

    /**
     * method to reverse a linked list and return the new head
     */
    public ListNode reverseList(ListNode head) {
        if(head==null) {
            return null;
        }
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head.next;

        while (next!=null) {
            curr.next = prev;
            prev =curr;
            curr = next;
            next = next.next;
        }
        curr.next = prev;
        prev = curr;
        return prev;
    }
}
