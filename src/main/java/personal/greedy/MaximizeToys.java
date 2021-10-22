package personal.greedy;

import java.util.Arrays;

public class MaximizeToys {
    static int toyCount(int N, int K, int arr[]) {
        Arrays.sort(arr);
        int count = 0;
        for(int x : arr) {
            if ((K-x)<0) {
                break;
            }
            count++;
            K = K-x;
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
