package personal.linked;

public class ReverseLinkedList {

    class Node {
        int value;
        Node next;
        Node(int value) {
            this.value = value;
        }
    }

    Node reverseList(Node head)
    {
        Node prev = null;
        Node curr = head, next;
        while(curr!=null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
