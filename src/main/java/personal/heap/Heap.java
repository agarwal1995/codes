package personal.heap;

import java.util.ArrayList;
import java.util.List;

public class Heap {
    List<Integer> list;
    int n;

    void heapify(int i) {
        int left = 2*i+1;
        int right = 2*i+2;
        int largest = i;
        if (left<n && list.get(left) > list.get(i)) {
            largest = left;
        }
        if(right<n && list.get(right) > list.get(largest)) {
            largest = right;
        }
        swap(i, largest);
        if (i!=largest) {
            heapify(largest);
        }
    }

    void buildHeap() {
        for(int i = n/2;i>=0;i--) {
            heapify(i);
        }
    }

    public void sort() {
        int k=n;
        for(int i=k-1;i> 0;i--) {
            swap(i, 0);
            n--;
            heapify(0);
        }
        n = list.size();
    }

    private void swap(int i, int j) {
        int t = list.get(i);
        list.set(i, list.get(j));
        list.set(j, t);
    }

    public int get() {
        return list.get(0);
    }

    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.list = new ArrayList<>();
        int[] Array = {1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17};
        for(int x : Array){
            heap.list.add(x);
        }
        heap.n = heap.list.size();
        heap.buildHeap();
        System.out.println(heap.list);
        heap.sort();
        System.out.println(heap.list);
    }
}
