package interviewBit.linkedlist;

public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode A) {
        if(A==null || A.next==null) {
            return A;
        }
        ListNode prev = A;
        ListNode curr = A.next;

        ListNode resultHead = null;
        ListNode resultList = resultHead;

        int count =1;
        while (curr!=null) {
            if(curr.val == prev.val) {
                count++;
            } else {
                if(count==1) {
                    if(resultHead==null) {
                        resultHead = prev;
                        resultList = prev;
                    } else {
                        resultList.next = prev;
                        resultList =resultList.next;
                    }
                }
                count=1;
            }
            prev = curr;
            curr = curr.next;
        }
        if(count==1) {
            resultList.next = prev;
            resultList = resultList.next;
        }
        if(resultList!=null) {
            resultList.next=null;
        }
        return resultHead;
    }
}
