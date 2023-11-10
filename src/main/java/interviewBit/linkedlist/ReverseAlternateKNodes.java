package interviewBit.linkedlist;

public class ReverseAlternateKNodes {

    public static void main(String[] args) {
        ListNode head = new ListNode(48);
        ListNode tempHead = head;
//        tempHead.next = new ListNode(68);
//        tempHead = tempHead.next;
//        tempHead.next = new ListNode(35);
//        tempHead = tempHead.next;
//        tempHead.next = new ListNode(1);
//        tempHead = tempHead.next;

        ListNode result = new ReverseAlternateKNodes().solve(head, 2);
        System.out.println(result);
    }
    public ListNode solve(ListNode A, int B) {
        ListNode prev = null;
        ListNode result = null;
        ListNode resultL = null;
        boolean doReverse = true;
        while(A!=null) {
            int k = B-1;
            ListNode tmp = A;
            A = A.next;
            while(k>0 && A!=null) {
                k--;
                prev = A;
                A = A.next;
            }
            prev.next = null;
            if (doReverse) {
                tmp = reverse(tmp);
            }
            if(result==null) {
                result = tmp;
                resultL = tmp;
            } else {
                while(resultL.next!=null) {
                    resultL = resultL.next;
                }
                resultL.next = tmp;
            }
            doReverse = !doReverse;
        }
        return  result;
    }

    public ListNode reverse(ListNode head) {
        if(head==null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head.next;
        while(curr!=null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
