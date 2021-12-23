package leetcode.studyplan.datastructure.first;

public class RemoveLinkedListElement {
    public ListNode removeElements(ListNode head, int val) {
        while(head!=null && head.val==val) {
            head = head.next;
        }
        ListNode result = head;
        ListNode prev = head;
        while(head!=null) {
            head = head.next;
            if(head!=null && head.val == val) {

            } else {
                prev.next = head;
                prev = prev.next;
            }
        }
        return result;
    }
}
