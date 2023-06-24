package interviewBit.linkedlist;

/**
 * Given a linked list A and a value B, partition it such that all nodes less than B come before nodes greater than or equal to B.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * @author raag
 */
public class PartitionList {

    /**
     * Maintain 2 list smaller which contains element smaller than B and greater which contains elements greater than B and link them at last
     */
    public ListNode partition(ListNode A, int B) {
        ListNode greater = new ListNode(0);
        ListNode smaller = new ListNode(0);
        ListNode headS=null, headG=null;
        ListNode curr = A;
        while(curr!=null) {
            if(curr.val<B) {
                if(headS==null) {
                    headS = smaller;
                }
                smaller.next = curr;
                smaller = smaller.next;
            } else {
                if(headG == null) {
                    headG = greater;
                }
                greater.next = curr;
                greater = greater.next;
            }
            curr = curr.next;
        }
        greater.next = null;
        if(headS==null) {
            return headG.next;
        }
        if(headG==null) {
            return headS.next;
        }
        smaller.next=headG.next;
        return headS.next;
    }
}
