package interviewBit.linkedlist;

public class ReverseLinkedListII {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode tempHead = head;
        tempHead.next = new ListNode(2);
        tempHead = tempHead.next;
        tempHead.next = new ListNode(3);
        tempHead = tempHead.next;
//        tempHead.next = new ListNode(4);
//        tempHead = tempHead.next;
//        tempHead.next = new ListNode(5);
//        tempHead = tempHead.next;
        ListNode result = new ReverseLinkedListII().reverseBetween(head, 1, 2);
        System.out.println(result);
    }
    public ListNode reverseBetween(ListNode A, int B, int C) {
        if(A==null || A.next==null || B==C) {
            return A;
        }
        ListNode result = A;
        ListNode prevHead = null;
        int x = 1;
        while(x<B) {
            prevHead = A;
            A = A.next;
            x++;
        }
        ListNode prev = null;
        ListNode curr = A;
        ListNode next = null;
        while(curr!=null && x<=C) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            x++;
        }
        if(B==1) {
            result = prev;
        } else {
            prevHead.next = prev;
        }
        while (prev.next!=null) {
            prev = prev.next;
        }
        prev.next = curr;

        return result;
    }
}
