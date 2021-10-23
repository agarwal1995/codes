package personal.cache;

import lombok.ToString;

public class Node<T> {

    T data;
    Node<T> prev;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        prev = null;
        next = null;
    }

    @Override
    public String toString() {
        return data + "";
    }
}
