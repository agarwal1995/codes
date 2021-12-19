package leetcode.studyplan.datastructure.first;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOf2Arrays {

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int x : nums1) {
            map.putIfAbsent(x, 0);
            map.put(x, map.get(x)+1);
        }
        List<Integer> list = new ArrayList<>();
        for(int y:nums2) {
            if(map.containsKey(y) && map.get(y)>0) {
                list.add(y);
                map.put(y, map.get(y)-1);
            }
        }
        int[] intersection = new int[list.size()];
        int i=0;
        for(int x:list) {
            intersection[i++] = x;
        }
        return intersection;
    }
}
