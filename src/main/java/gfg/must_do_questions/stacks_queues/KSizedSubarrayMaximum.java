package gfg.must_do_questions.stacks_queues;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class KSizedSubarrayMaximum {

    public static void main(String[] args) {
        KSizedSubarrayMaximum kSizedSubarrayMaximum = new KSizedSubarrayMaximum();
        System.out.println(kSizedSubarrayMaximum.max_of_subarrays(new int[]{1,2,3,1,4,5,2,3,6}, 3));
        System.out.println(kSizedSubarrayMaximum.max_of_subarrays(new int[]{8, 5, 10, 7, 9, 4, 15, 12, 90, 13}, 4));
    }


    // Function to find maximum of each subarray of size k.
    public ArrayList<Integer> max_of_subarrays(int[] arr, int k) {
        Deque<Integer> queue = new LinkedList<>();

        ArrayList<Integer> list = new ArrayList<>();

        int i=0;
        for (i=0;i<k;i++) {
            while (!queue.isEmpty() && arr[queue.peekLast()]<=arr[i]) {
                queue.pollLast();
            }
            queue.add(i);
        }

        list.add(arr[queue.peek()]);

        for (i=k;i<arr.length;i++) {
            while (!queue.isEmpty() && arr[queue.peekLast()]<=arr[i]) {
                queue.pollLast();
            }

            queue.add(i);


            while (queue.size()>1 && queue.peek() <= (i - k)) {
                queue.poll();
            }
            list.add(arr[queue.peek()]);
        }
        return list;
    }
}
