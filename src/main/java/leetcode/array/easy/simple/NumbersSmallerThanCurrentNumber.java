package leetcode.array.easy.simple;

public class NumbersSmallerThanCurrentNumber {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] cumulative = new int[102];
        for(int i=0;i<nums.length;i++) {
            cumulative[nums[i]]++;
        }
        int[] res = new int[nums.length];
        for(int i=1;i<=100;i++) {
            cumulative[i] = cumulative[i] + cumulative[i-1];
        }

        for(int k=0;k<nums.length;k++) {
            if(nums[k]==0) {
                res[k] = 0;
                continue;
            }
            res[k] = cumulative[nums[k]-1];
        }
        return res;
    }
}
