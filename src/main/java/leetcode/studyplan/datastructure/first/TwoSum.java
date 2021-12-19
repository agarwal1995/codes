package leetcode.studyplan.datastructure.first;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        int i = 0;
        int[] solution = new int[2];
        for(int x : nums) {
            if(map.containsKey(target - nums[i])) {
                solution[0] = map.get(target-nums[i]);
                solution[1] = i;
                break;
            }
            map.put(nums[i],i);
            i++;
        }
        return solution;
    }
}
