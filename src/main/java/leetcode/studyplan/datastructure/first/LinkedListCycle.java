package leetcode.studyplan.datastructure.first;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        while(slowPointer!=null && fastPointer!=null && fastPointer.next!=null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            if(slowPointer == fastPointer) {
                return true;
            }
        }
        return false;
    }
}
