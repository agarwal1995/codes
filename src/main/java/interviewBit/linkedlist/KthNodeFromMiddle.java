package interviewBit.linkedlist;

/**
 * @author raag
 */
public class KthNodeFromMiddle {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode tempHead = head;
        tempHead.next = new ListNode(14);
        tempHead = tempHead.next;
        tempHead.next = new ListNode(6);
        tempHead = tempHead.next;
        tempHead.next = new ListNode(16);
        tempHead = tempHead.next;
        tempHead.next = new ListNode(4);
        tempHead = tempHead.next;
        tempHead.next = new ListNode(10);
        tempHead = tempHead.next;
        System.out.println(new KthNodeFromMiddle().solve(head,  2));


    }

    public int solve(ListNode A, int B) {
        if (A==null || (A.next==null && B!=0)) {
            return -1;
        }
        int mid = findMiddle(A);
        int x = mid-B;
        while (x>0) {
            x--;
            if (x==0) {
                return A.val;
            }
            A = A.next;
        }
        return -1;
    }

    private int findMiddle(ListNode A) {
        ListNode slow = A;
        ListNode fast = A;

        ListNode tmp = A;

        int mid = 1;
        while (tmp!=null && tmp.next!=null) {
            fast = fast.next;
            tmp = tmp.next;
            mid++;
            if (tmp!=null && tmp.next!=null) {
                fast = fast.next;
                slow = slow.next;
                tmp = tmp.next;
            }
        }
        return mid;
    }
}
