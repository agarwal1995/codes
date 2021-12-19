package personal.heap;

public class HeapTest {
    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.add(4);
        heap.add(5);
        heap.add(6);
        heap.add(3);
        heap.add(2);
        System.out.println(heap);
        System.out.println(heap.poll());
        System.out.println(heap.poll());
        System.out.println(heap.poll());
        System.out.println(heap);
    }
}
