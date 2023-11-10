package interviewBit.linkedlist;

public class SwapListNodeInPairs {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode tempHead = head;
        tempHead.next = new ListNode(2);
        tempHead = tempHead.next;
        tempHead.next = new ListNode(3);
        tempHead = tempHead.next;
        tempHead.next = new ListNode(4);
        tempHead = tempHead.next;
        new SwapListNodeInPairs().swapPairs(head);
    }
    public ListNode swapPairs(ListNode A) {
        if(A==null || A.next==null) {
            return A;
        }
        ListNode resultHead = A.next;
        ListNode resultList = A;
        A = A.next.next;
        resultHead.next = resultList;
        resultList.next=null;
        while(A!=null && A.next!=null) {
            ListNode tmp1 = A;
            ListNode tmp2 = A.next;
            A = A.next.next;
            tmp1.next= null;
            resultList.next = tmp2;
            resultList.next.next = tmp1;
            resultList = resultList.next.next;
        }

        if(A!=null) {
            resultList.next = A;
        }
        return resultHead;
    }
}
