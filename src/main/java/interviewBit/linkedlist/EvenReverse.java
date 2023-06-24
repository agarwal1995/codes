package interviewBit.linkedlist;

/**
 * Given a linked list A , reverse the order of all nodes at even positions.
 * @author raag
 */
public class EvenReverse {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode temp = head;
        temp.next = new ListNode(2);
        temp = temp.next;
        temp.next = new ListNode(3);
        temp = temp.next;
//        temp.next = new ListNode(4);
//        temp = temp.next;

        ListNode result = new EvenReverse().solve(head);
        System.out.println(result);
    }

    /**
     * Separate into 2 list even and odd position
     * find even list reverse
     * merge 2 list 1 by 1
     */
    public ListNode solve(ListNode A) {
        //

        if(A==null || A.next==null) {
            return A;
        }
        int count = 0;
        ListNode oddListH = A;
        ListNode evenListH = A.next;
        ListNode oddList = A;
        ListNode evenList = A.next;
        A = A.next.next;
        while(A!=null) {
            count++;
            if(count%2==0) {
                evenList.next = A;
                evenList = evenList.next;
                A = A.next;
            } else {
                oddList.next = A;
                oddList = oddList.next;
                A = A.next;
                oddList.next = null;
            }
        }
        oddList.next=null;
        evenList.next= null;
        ListNode evenListR = reverse(evenListH);

        return merge(oddListH, evenListR);
    }

    public ListNode reverse(ListNode head) {
        if(head==null || head.next==null) {
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        while (curr!=null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public ListNode merge(ListNode a, ListNode b) {

        ListNode resultL = new ListNode(0);
        ListNode resultH = resultL;
        while (a != null && b != null) {
            resultL.next = a;
            a = a.next;
            resultL = resultL.next;
            resultL.next = b;
            b = b.next;
            resultL = resultL.next;
        }
        if(a!=null) {
            resultL.next = a;
        }
        return resultH.next;
    }
}
