package interviewBit.linkedlist;

/**
 * Given a Linked List A consisting of N nodes.
 * The Linked List is binary i.e data values in the linked list nodes consist of only 0's and 1's.
 * You need to sort the linked list and return the new linked list.
 *
 * @author raag
 */
public class SortBinaryLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode tempHead = head;
        tempHead.next = new ListNode(0);
        tempHead = tempHead.next;
        tempHead.next = new ListNode(0);
        tempHead = tempHead.next;
        tempHead.next = new ListNode(1);
        tempHead = tempHead.next;
        print(head);
        print(new SortBinaryLinkedList().solve(head));
    }

    public static void print(ListNode head) {
        while (head!=null) {
            System.out.println(head.val);
            head=head.next;
        }
    }

    /**
     * Maintain 2 list one of zero other of ones, and then make zero -> last = ones
     */
    public ListNode solve(ListNode A) {
        ListNode zeros = null;
        ListNode zeroS = null;
        ListNode ones = null;
        ListNode oneS = null;
        while (A!=null) {
            if(A.val==0) {
                if(zeros==null) {
                    zeros = A;
                    zeroS = A;
                } else {
                    zeros.next=A;
                    zeros = zeros.next;
                }
            } else {
                if(ones==null) {
                    ones=A;
                    oneS = A;
                } else {
                    ones.next=A;
                    ones = ones.next;
                }
            }
            A=A.next;
        }
        if(oneS!=null)
        ones.next=null;
        if(zeroS!=null)
        zeros.next=oneS;
        return zeroS;
    }
}


/**
 * Definition for singly-linked list.
 */
class ListNode {
      public int val;
      public ListNode next;
 ListNode(int x) { val = x; next = null; }
 }
