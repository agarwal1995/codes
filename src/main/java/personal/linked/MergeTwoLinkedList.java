package personal.linked;

public class MergeTwoLinkedList {



    Node sortedMerge(Node head1, Node head2) {
        if(head1==null) {
            return head2;
        }
        if (head2 ==null) {
            return head1;
        }

        Node result;

        if(head1.data<head2.data) {
            result = head1;
            result.next = sortedMerge(head1.next, head2);
        } else {
            result = head2;
            result.next = sortedMerge(head1, head2.next);
        }
        return result;

    }
}
