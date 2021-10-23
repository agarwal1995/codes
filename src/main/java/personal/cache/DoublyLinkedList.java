package personal.cache;

import lombok.ToString;

public class DoublyLinkedList<T> {

    Node<T> head, tail;

    public DoublyLinkedList() {
        head = null;
        tail = null;
    }

    @Override
    public String toString() {
        print();
        return "";
    }

    void addNode(Node<T> node) {
        if(head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
    }

    void removeNode(Node<T> node) {
        Node<T> prevNode = node.prev;
        Node<T> nextNode = node.next;
        if (prevNode!=null) {
            prevNode.next = nextNode;
        }
        if (nextNode!=null) {
            nextNode.prev = prevNode;
        }
    }

    void removeLastNode() {
        if(tail == null) {
            return;
        }
        if(tail == head) {
            head = tail = null;
            return;
        }
        if (tail.prev!=null) {
            tail.prev.next = null;
            tail = tail.prev;
        }
    }

    void print() {
        System.out.println("====");
        Node<T> node = head;
        while(node!=null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
        System.out.println("====");

    }

    public static void main(String[] args) {
        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node3 = new Node<>(3);
        Node<Integer> node4 = new Node<>(4);
        doublyLinkedList.addNode(node1);
        doublyLinkedList.addNode(node2);
        doublyLinkedList.addNode(node3);
        doublyLinkedList.addNode(node4);

        doublyLinkedList.print();

        doublyLinkedList.removeNode(node3);

        doublyLinkedList.print();

        doublyLinkedList.removeLastNode();
        doublyLinkedList.print();

        doublyLinkedList.removeLastNode();
        doublyLinkedList.removeLastNode();
        doublyLinkedList.removeLastNode();
        doublyLinkedList.print();


    }
}
