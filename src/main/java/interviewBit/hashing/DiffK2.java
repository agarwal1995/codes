package interviewBit.hashing;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array A of integers and another non-negative integer B .
 * Find if there exists 2 indices i and j such that A[i] - A[j] = B and i != j.
 */
public class DiffK2 {

    /**
     * Iterate the array twice once in normal order, then in reverse order (because we want to find the difference then A-B is different from B-A)
     * Maintain a map of the element been iterated, and return true if x-A is present in map
     */
    public int diffPossible(final List<Integer> A, int B) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<A.size();i++) {
            if(map.containsKey(B+A.get(i))) {
                return 1;
            }
            map.put(A.get(i), i);
        }

        map = new HashMap<>();
        for (int i=A.size()-1;i>=0;i--) {
            if(map.containsKey(B+A.get(i))) {
                return 1;
            }
            map.put(A.get(i), i);
        }
        return 0;
    }
}
