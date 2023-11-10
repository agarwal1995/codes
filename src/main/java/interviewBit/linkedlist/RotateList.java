package interviewBit.linkedlist;

public class RotateList {
    public ListNode rotateRight(ListNode A, int B) {
        int size = 0;
        ListNode curr = A;
        while(curr!=null) {
            curr = curr.next;
            size++;
        }
        B = B%size;
        if(B==0) {
            return A;
        }
        int x = size - B-1;
        ListNode start = A;
        while(x>0) {
            start = start.next;
            x--;
        }
        ListNode newStart = start.next;
        ListNode temp = newStart;
        start.next=null;
        while(temp.next!=null) {
            temp = temp.next;
        }
        temp.next = A;
        return newStart;
    }
}
