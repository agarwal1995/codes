package leetcode.array.easy.simple;

public class RunningSum1DArray {
    public int[] runningSum(int[] nums) {
        int res[] = new int[nums.length];
        res[0] = nums[0];
        for(int i=1;i<nums.length;i++) {
            res[i] = nums[i] + res[i-1];
        }
        return res;
    }
}
