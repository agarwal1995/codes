package personal.cache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<T> {
    int maxCapacity;
    Map<T, Node<T>> linkedListMap;
    DoublyLinkedList<T> doublyLinkedList;

    public LRUCache(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.linkedListMap = new HashMap<>();
        doublyLinkedList = new DoublyLinkedList<>();
    }

    Node<T> refer(T key) {
        Node<T> node;
        if (linkedListMap.containsKey(key)) {
            node = linkedListMap.get(key);
            doublyLinkedList.removeNode(node);
        } else {
            node = new Node<>(key);
            if(linkedListMap.size() == maxCapacity) {
                doublyLinkedList.removeLastNode();
                linkedListMap.remove(key);
            }
        }
        doublyLinkedList.addNode(node);
        linkedListMap.put(key, node);
        return linkedListMap.get(key);
    }



    public static void main(String[] args) {
        LRUCache<Integer> lruCache = new LRUCache<>(5);
        System.out.println(lruCache.refer(1));
        System.out.println(lruCache.doublyLinkedList);
        System.out.println(lruCache.refer(2));
        System.out.println(lruCache.doublyLinkedList);

        System.out.println(lruCache.refer(3));
        System.out.println(lruCache.doublyLinkedList);
        System.out.println(lruCache.refer(4));
        System.out.println(lruCache.doublyLinkedList);
        System.out.println(lruCache.refer(5));
        System.out.println(lruCache.doublyLinkedList);
        System.out.println(lruCache.refer(6));
        System.out.println(lruCache.doublyLinkedList);
        System.out.println(lruCache.refer(3));
        System.out.println(lruCache.doublyLinkedList);
        System.out.println(lruCache.refer(5));
        System.out.println(lruCache.doublyLinkedList);
        System.out.println(lruCache.refer(2));
        System.out.println(lruCache.doublyLinkedList);
    }
}
