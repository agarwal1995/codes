package interviewBit.linkedlist;

/**
 * You are given two linked lists representing two non-negative numbers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * @author raag
 */
public class AddTwoNumbersAsList {

    /**
     * maintain a carry var to sum up at every step
     */
    public ListNode addTwoNumbers(ListNode A, ListNode B) {
        int carry = 0;
        ListNode result = null;
        ListNode resultH = null;
        while(A!=null && B!=null) {
            int x = A.val + B.val + carry;
            carry = x/10;
            ListNode newNode = new ListNode(x%10);
            if(result==null) {
                result = newNode;
                resultH = newNode;
            } else {
                result.next = newNode;
                result = result.next;
            }
            A= A.next;
            B = B.next;
        }

        while(A!=null) {
            int x = A.val + carry;
            carry = x/10;
            ListNode newNode = new ListNode(x%10);
            if(result==null) {
                result = newNode;
                resultH = newNode;
            } else {
                result.next = newNode;
                result = result.next;
            }
            A = A.next;
        }

        while(B!=null) {
            int x = B.val + carry;
            carry = x/10;
            ListNode newNode = new ListNode(x%10);
            if(result==null) {
                result = newNode;
                resultH = newNode;
            } else {
                result.next = newNode;
                result = result.next;
            }
            B = B.next;
        }
        if(carry!=0) {
            result.next = new ListNode(carry);
            result = result.next;
        }
        return resultH;
    }
}
