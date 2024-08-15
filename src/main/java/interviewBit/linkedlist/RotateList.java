package interviewBit.linkedlist;

public class RotateList {


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
        new RotateList().rotateRight(head, 2);
    }

    public ListNode rotateRight(ListNode listNode, int B) {
        // calculate total size
        ListNode tmp = listNode;
        int size = 0;
        while (tmp!=null) {
            size++;
            tmp = tmp.next;
        }

        if (B%size==0) {
            return listNode;
        }

        int k = size - (B%size);

        tmp = listNode;
        ListNode prev = null;
        while (k>=1) {
            k--;
            prev = tmp;
            tmp = tmp.next;
        }

        ListNode newHead = tmp;

        ListNode newOrder = newHead;
        prev.next=null;

        while (newOrder.next!=null) {
            newOrder = newOrder.next;
        }
        newOrder.next = listNode;
        return newHead;

    }
    public ListNode rotateRightOld(ListNode A, int B) {
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
