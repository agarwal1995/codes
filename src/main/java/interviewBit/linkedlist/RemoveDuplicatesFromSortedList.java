package interviewBit.linkedlist;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * @author raag
 */
public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode A) {
        if(A==null || A.next==null) {
            return A;
        }
        ListNode result = A;
        ListNode resultHead = A;
        ListNode prev = A;
        A = A.next;
        while(A!=null) {
            if(A.val!=prev.val) {
                result.next = A;
                result = result.next;
            }
            prev = A;
            A = A.next;
        }
        result.next = null;
        return resultHead;
    }
}
