package interviewBit.linkedlist;

public class ReorderList {
    public ListNode reorderList(ListNode A) {
        ListNode middle = middle(A);
        ListNode reverseSecond = reverse(middle.next);
        middle.next = null;
        return merge(A,reverseSecond);
    }

    public ListNode merge(ListNode a, ListNode b) {
        ListNode result = new ListNode(0);
        ListNode resultH = result;
        while(a!=null && b!=null) {
            result.next = a;
            a = a.next;
            result = result.next;
            result.next = b;
            b = b.next;
            result = result.next;
        }
        if(a!=null) {
            result.next = a;
        }
        return resultH.next;
    }

    public ListNode middle(ListNode A) {
        ListNode slow = A;
        ListNode fast = A;
        while(fast!=null) {
            fast=fast.next;
            if(fast!=null) {
                slow = slow.next;
                fast = fast.next;
            }
        }
        return slow;
    }

    public ListNode reverse(ListNode A) {
        ListNode prev = null;
        ListNode curr = A;
        ListNode next = null;
        while(curr!=null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
