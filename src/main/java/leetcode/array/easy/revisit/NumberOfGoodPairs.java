package leetcode.array.easy.revisit;

import java.util.HashMap;
import java.util.Map;

public class NumberOfGoodPairs {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            map.putIfAbsent(nums[i], 0);
            map.put(nums[i], map.get(nums[i])+1);
        }
        int total = 0;
        for(Map.Entry<Integer, Integer> mp:map.entrySet()) {
            if(mp.getValue()>1) {
                total = total + (mp.getValue() * (mp.getValue()-1) )/2;
            }
        }
        return total;
    }
}
