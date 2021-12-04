package personal.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElementInStream {

    static int[] kthLargest(int k, int[] arr, int n) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        for(int i=0;i<n;i++) {
            if(minHeap.size()<k) {
                minHeap.add(arr[i]);
                if(minHeap.size()!=k) {
                    arr[i] = -1;
                } else {
                    arr[i] = minHeap.peek();
                }
                continue;
            }

            if(minHeap.peek() < arr[i]) {
                minHeap.poll();
                minHeap.add(arr[i]);
            }
            arr[i] = minHeap.peek();
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {6,5,4,3,2,1};
        System.out.println(Arrays.toString(kthLargest(4, arr, 6)));
    }
}
