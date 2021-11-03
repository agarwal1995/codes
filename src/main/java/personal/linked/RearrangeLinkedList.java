package personal.linked;

public class RearrangeLinkedList {

    void rearrangeEvenOdd(Node head) {
        if(head ==null) {
            return;
        }
        boolean flag = true;
        Node initial = head;
        Node oddHead = head, odd = null, even = null, evenHead = head.next;
        while(head!=null) {
            if(flag) {
                if (odd == null) {
                    odd = head;
                } else {
                    odd.next = head;
                    odd = odd.next;
                }
                flag = false;
            } else {
                if(even == null) {
                    even = head;
                } else {
                    even.next = head;
                    even = even.next;
                }
                flag = true;
            }
            head = head.next;
        }
        if(flag) {
            odd = evenHead;
        } else {
            odd.next = evenHead;
        }
    }
}
