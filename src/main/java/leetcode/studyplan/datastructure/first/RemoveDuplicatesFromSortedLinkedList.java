package leetcode.studyplan.datastructure.first;

public class RemoveDuplicatesFromSortedLinkedList {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null) {
            return head;
        }
        ListNode prevNode = head;
        ListNode prev = head;
        head = head.next;
        while(head!=null) {
            if(prev.val!=head.val) {
                prev.next = head;
                prev = head;
            }
            head = head.next;
        }
        prev.next = null;
        return prevNode;
    }
}
