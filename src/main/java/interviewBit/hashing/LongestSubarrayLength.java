package interviewBit.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayLength {

    public int solve(ArrayList<Integer> A) {
        Map<Integer, Integer> map = new HashMap<>();

        int zeroes = 0;
        int ones = 0;

        int max = Integer.MIN_VALUE;
        for(int i=0;i<A.size();i++) {
            if(A.get(i)==0) {
                zeroes++;
            } else if(A.get(i)==1) {
                ones++;
            }
            map.putIfAbsent(ones-zeroes, i);
            if(ones>zeroes) {
                max = i;
            } else {
                if(map.get(1)!=null) {
                    max = Math.max(max, i-map.get(1));
                }
            }
        }
        return max;
    }
}
