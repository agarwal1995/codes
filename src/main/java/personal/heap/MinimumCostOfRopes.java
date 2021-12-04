package personal.heap;

import java.util.PriorityQueue;

public class MinimumCostOfRopes {

    long minCost(long arr[], int n) {
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
        for (long x : arr) {
            priorityQueue.add(x);
        }

        long sum = 0;
        while (priorityQueue.size()>1) {
            long first = priorityQueue.poll();
            long second = priorityQueue.poll();
            long third = first + second;
            sum = sum + third;
            priorityQueue.add(third);
        }
        return sum;
    }

    public static void main(String[] args) {
        long arr[] = {4, 3, 2, 6};
        System.out.println(new MinimumCostOfRopes().minCost(arr, 4));
    }
}
