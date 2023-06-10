package interviewBit.hashing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Given are Three arrays A, B and C.
 * Return the sorted list of numbers that are present in atleast 2 out of the 3 arrays.
 */
public class TwoOutOfThree {

    /**
     * Filter Out common and uncommon elements from A and B
     * Then filter out from aggregated uncommon elements of A,B with C
     *
     * @return result in Sorted Order
     */
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {
        Set<Integer> sol = new HashSet<>();
        Set<Integer> set = new HashSet<>(A);
        Set<Integer> set2 = new HashSet<>();
        for (int x: B) {
            if(set.contains(x)) {
                sol.add(x);
            } else {
                set2.add(x);
            }
        }
        set.addAll(set2);
        for (int x: C) {
            if(set.contains(x)) {
                sol.add(x);
            }
        }
        ArrayList<Integer> result = new ArrayList<>(sol);
        Collections.sort(result);
        return result;
    }
}
