package personal.heap;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

@Data
@ToString
public class Heap {

    private List<Integer> list;
    private int heapSize;

    Heap() {
        list = new ArrayList<>();
        heapSize = 0;
    }

    public void add(Integer t) {
        list.add(t);
        heapSize++;
        int i = heapSize-1;
        while (true) {
            int parent = parent(i);
            if(parent>= 0 && list.get(parent)>list.get(i)) {
                swap(i, parent);
                i = parent;
            } else {
                break;
            }
        }
    }

    public Integer peek() {
        if(heapSize == 0) {
            return null;
        }
        return list.get(--heapSize);
    }

    public Integer poll() {
        if (heapSize == 0) {
            return null;
        }
        Integer polledElement = list.get(0);
        heapSize--;
        list.set(0, list.get(heapSize));
        list.remove(heapSize);
        for(int i = heapSize/2;i>=0;i--) {
            heapify(i);
        }
        return polledElement;
    }

    private void heapify(int i) {
        int leftChild  = 2*i + 1;
        int rightChild = 2*i + 2;
        int smallest = i;
        if(leftChild<heapSize && list.get(leftChild)< list.get(i)) {
            smallest = leftChild;
        }
        if(rightChild<heapSize && list.get(rightChild) < list.get(smallest)) {
            smallest = rightChild;
        }
        if(smallest!=i) {
            swap(i, smallest);
            heapify(smallest);
        }
    }

    private void swap(int i, int j) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    private int parent(int i) {
        return (i-1)/2;
    }
}
