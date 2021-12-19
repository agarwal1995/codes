package leetcode.studyplan.datastructure.first;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int maxTillNow = Integer.MIN_VALUE;

        for(int x : nums) {
            if(maxTillNow<0) {
                maxSum = Math.max(maxSum, maxTillNow);
                maxTillNow = 0;
            }
            maxTillNow = maxTillNow + x;
            maxSum = Math.max(maxSum, maxTillNow);
        }
        return maxSum;
    }
}
