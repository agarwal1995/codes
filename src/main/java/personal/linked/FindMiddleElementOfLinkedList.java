package personal.linked;

public class FindMiddleElementOfLinkedList {

    int getMiddle(Node head) {
        Node slow = head;
        Node fast = head;

        while (slow!=null && fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }
}
