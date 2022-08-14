package leetcode.array.easy.revisit;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> m = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            if(m.get(target-nums[i]) !=null) {
                int[] sol = new int[2];
                sol[0] = m.get(target-nums[i]);
                sol[1] = i;
                return sol;
            } else {
                m.put(nums[i], i);
            }
        }
        return new int[]{-1};
    }
}
