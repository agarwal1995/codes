package interviewBit.twoPointers;

import java.util.ArrayList;

/**
 * Given an array 'A' of sorted integers and another non-negative integer B, find if there exist 2 indices i and j such that A[i] - A[j] = k, i != j.
 * Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 * Try doing this in less than linear space complexity.
 * @author raag
 */
public class DiffK {

    /**
     * Maintain 2 pointers and find the difference between jth and ith element as the array is sorted
     */
    public int diffPossible(ArrayList<Integer> list, int B) {
        int i=0,j=1;
        int n = list.size();
        while (i<n && j<n) {
            if(i==j) {
                j++;
                continue;
            }
            int diff = list.get(j) - list.get(i);
            if(diff==B) {
                return 1;
            }
            if(diff>B) {
                i++;
            } else {
                j++;
            }
        }
        return 0;
    }
}
