package interviewBit.linkedlist;

/**
 * Given a singly linked list and an integer K, reverses the nodes of the
 * list K at a time and returns modified linked list.
 * @author raag
 */
public class KReverseLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode tempHead = head;
        tempHead.next = new ListNode(2);
        tempHead = tempHead.next;
        tempHead.next = new ListNode(3);
        tempHead = tempHead.next;
        tempHead.next = new ListNode(4);
        tempHead = tempHead.next;
        tempHead.next = new ListNode(5);
        tempHead = tempHead.next;
        new KReverseLinkedList().reverseList(head, 2);
    }

    /**
     * maintain a counter k and part the k nodes from the list, and reverse the part individually
     */
    public ListNode reverseList(ListNode A, int B) {
        ListNode prev = null;
        ListNode result = null;
        ListNode resultL = null;
        while(A!=null) {
            int k = B-1;
            ListNode tmp = A;
             prev = A;
            A = A.next;
            while(k>0 && A!=null) {
                k--;
                prev = A;
                A = A.next;
            }
            prev.next = null;
            tmp = reverse(tmp);
            if(result==null) {
                result = tmp;
                resultL = tmp;
            } else {
                while(resultL.next!=null) {
                    resultL = resultL.next;
                }
                resultL.next = tmp;
            }
        }
        return  result;
    }

    /**
     * method to reverse a linked list and return the new head
     */
    public ListNode reverse(ListNode head) {
        if(head==null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head.next;
        while(curr!=null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
