package discussions.oracle;

import lombok.Data;

import java.util.Stack;

public class ReverseLinkedList {

    // 1 2
    // prev {2,1}
    // head {2,1}
    // next {null}
    public static Node revere(Node head) {
//        discussions.oracle.Node current =;
        Node previous = null;
        Node next;

        while (head!=null) {
            next = head.next;
            head.next = previous;
            previous = head;
            head = next;
        }
        return previous;
    }

    public static Node reverseWithK(Node head, int k) {
        Stack<Node> stack = new Stack<>();
        int c=0;
        Node current = null;
        Node newHead = null;
        while (head!=null) {
            if(stack.size()==k) {
                while (!stack.isEmpty()) {
                    Node x = stack.pop();
                    if(current==null) {
                        newHead = x;
                        current = x;
                        continue;
                    }
                    current.next = x;
                    current = current.next;
                }
            }
            Node node = head;
            head = head.next;
            node.next=null;
            stack.push(node);
        }
        while (!stack.isEmpty()) {
            Node x = stack.pop();
            if(current==null) {
                newHead = x;
                current = x;
                continue;
            }
            current.next = x;
            current = current.next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        Node n = new Node(1);
        n.next = new Node(2);
        n.next.next = new Node(3);
        n.next.next.next = new Node(4);
        n.next.next.next.next = new Node(5);
        n = reverseWithK(n,3);
        while(n!=null) {
            System.out.println(n.data +" ");
            n=n.next;
        }
    }
}
// 1 2 3 4 5
@Data
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
