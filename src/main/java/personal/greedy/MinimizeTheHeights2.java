package personal.greedy;

public class MinimizeTheHeights2 {

    int getMinDiff(int[] arr, int n, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int x : arr) {
            max = Math.max(max, x-k>=0? x-k:x+k);
            min = Math.min(min, x+k);
        }
        return max-min;
    }

    public static void main(String[] args) {
        int[] ar = {3,9,12,20,16};
        System.out.println(new MinimizeTheHeights2().getMinDiff(ar, 5, 3));
    }
}
