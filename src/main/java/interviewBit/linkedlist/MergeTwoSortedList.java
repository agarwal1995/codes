package interviewBit.linkedlist;

/**
 * @author raag
 */
public class MergeTwoSortedList {

    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        ListNode result = null;
        ListNode head = null;

        while (A!=null && B!=null) {
            if (A.val<B.val) {
                if (head == null) {
                    head = A;
                    result = A;
                } else {
                    result.next = A;
                    result = result.next;
                }
                A = A.next;
            } else {
                if (head == null) {
                    head = B;
                    result = B;
                } else {
                    result.next = B;
                    result = result.next;
                }
                B = B.next;
            }
        }

        while (A!=null) {
            if (head == null) {
                head = A;
                result = A;
            } else {
                result.next = A;
                result = result.next;
            }
            A = A.next;
        }

        while (B!=null) {
            if (head == null) {
                head = B;
                result = B;
            } else {
                result.next = B;
                result = result.next;
            }
            B = B.next;
        }
        return head;
    }
}
