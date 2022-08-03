package interviewBit.hashing;

import java.util.*;

public class TwoSum {

    public ArrayList<Integer> twoSum(final List<Integer> A, int B) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<A.size();i++) {
            if(map.containsKey(B-A.get(i))) {
                return new ArrayList<>(Arrays.asList(new Integer[]{map.get(i), i}));
            } else {
                map.put(A.get(i), i);
            }
        }
        return new ArrayList<>();
    }
}
