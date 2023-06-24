package interviewBit.linkedlist;

/**
 * Sort a linked list using insertion sort.
 * We have explained Insertion Sort at Slide 7 of Arrays
 * Insertion Sort Wiki has some details on Insertion Sort as well.
 * @author raag
 */
public class InsertionSortList {
    
    public ListNode insertionSortList(ListNode A) {
        ListNode sortedList = null;

        while (A!=null) {
            ListNode nodeToInsert = A;
            A = A.next;
            nodeToInsert.next = null;

            if(sortedList==null || sortedList.val>=nodeToInsert.val) {
                nodeToInsert.next = sortedList;
                sortedList = nodeToInsert;
                continue;
            }

            ListNode prev = sortedList;
            ListNode curr = sortedList.next;
            while (curr!=null) {
                if(nodeToInsert.val <= curr.val) {
                    nodeToInsert.next = curr;
                    prev.next = nodeToInsert;
                    break;
                }
                prev = curr;
                curr = curr.next;
            }
            if(curr==null) {
                prev.next = nodeToInsert;
            }
        }
        return sortedList;
    }
}
