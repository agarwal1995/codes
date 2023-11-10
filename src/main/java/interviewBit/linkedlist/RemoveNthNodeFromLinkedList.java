package interviewBit.linkedlist;

public class RemoveNthNodeFromLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode temp = head;
        temp.next = new ListNode(2);
        temp = temp.next;
        temp.next = new ListNode(3);
        temp = temp.next;
        temp.next = new ListNode(4);
        temp = temp.next;
        temp.next = new ListNode(5);
        temp = temp.next;

        System.out.println(new RemoveNthNodeFromLinkedList().removeNthFromEnd(head, 1));
    }
    public ListNode removeNthFromEnd(ListNode A, int B) {
        int size = 0;
        if(A==null || B==0) {
            return A;
        }
        ListNode curr = A;
        while(curr!=null) {
            size++;
            curr = curr.next;
        }
        if(size<=B) {
            return A.next;
        }
        int counter = size-B-1;
        curr  = A;
        while(counter>0) {
            curr = curr.next;
            counter--;
        }
        curr.next = curr.next.next;
        return A;
    }
}
