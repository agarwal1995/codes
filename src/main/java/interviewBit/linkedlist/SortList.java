package interviewBit.linkedlist;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 * @author raag
 */
public class SortList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode tempHead = head;
        tempHead.next = new ListNode(5);
        tempHead = tempHead.next;
        tempHead.next = new ListNode(4);
        tempHead = tempHead.next;
        tempHead.next = new ListNode(3);
        tempHead = tempHead.next;
        print(head);
        ListNode result = new SortList().sortList(head);
        print(result);
    }

    public static void print(ListNode head) {
        while (head!=null) {
            System.out.println(head.val);
            head=head.next;
        }
    }

    /**
     * Use merge sort algorithm to sort the linked list
     * divide the list in half and merge the 2 parts together recursively
     */
    public ListNode sortList(ListNode A) {
        if (A==null || A.next==null) {
            return A;
        }
        ListNode middle = midNode(A);
        ListNode nextOfMiddle = middle.next;

        middle.next = null;

        ListNode left = sortList(A);
        ListNode right = sortList(nextOfMiddle);

        return merge(left, right);
    }

    /**
     * merge the 2 sorted part of the array
     */
    public ListNode merge(ListNode A, ListNode B) {
        if(A==null) {
            return B;
        }
        if(B==null) {
            return A;
        }
        ListNode result = null;
        if(A.val < B.val) {
            result = A;
            result.next = merge(A.next, B);
        } else {
            result = B;
            result.next = merge(A, B.next);
        }
        return result;
    }

    /**
     * method to find the middle node of the list using 2 pointers
     */
    public ListNode midNode(ListNode A) {
        ListNode slow = A;
        ListNode fast = A;
        while (fast!=null) {
            fast = fast.next;
            if(slow!=null && fast!=null && fast.next!=null) {
                slow = slow.next;
                fast = fast.next;
            }
        }
        return slow;
    }
    
}
