package interviewBit.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FirstRepeatingElement {

    public int solve(ArrayList<Integer> A) {
        int minIndex = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<A.size();i++) {
            if(map.containsKey(A.get(i))) {
                minIndex = Math.min(minIndex, i);
            } else {
                map.put(A.get(i), i);
            }
        }
        if(minIndex!=Integer.MAX_VALUE) {
            return A.get(minIndex);
        }
        return -1;
    }
}
