package discussions.vymo;

public class MaxSlidingWindow {

    private static void maxSlidingWindow(int[] array, int k) {
        int n = array.length;

        int[] rightSideArray = new int[n];
        int[] leftSideArray = new int[n];

        int max = Integer.MIN_VALUE;
        int maxReverse = Integer.MIN_VALUE;
        int j = n-1;
        for(int i =0;i<n;i++) {
            if (i%k==0) {
                max = Integer.MIN_VALUE;
                maxReverse = Integer.MIN_VALUE;
            }
            rightSideArray[i] = max = Math.max(max, array[i]);
            leftSideArray[j] = maxReverse = Math.max(array[j--], maxReverse);
        }

        System.out.println();
        for(int i=0;i<=n-k;i++) {
            int maxValue = Math.max(rightSideArray[i+k-1], leftSideArray[i]);
            System.out.print(maxValue + "  ");
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        maxSlidingWindow(nums, 3);
    }
}
