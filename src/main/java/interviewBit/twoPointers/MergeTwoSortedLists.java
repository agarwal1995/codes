package interviewBit.twoPointers;

import java.util.ArrayList;

/**
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * @author raag
 */
public class MergeTwoSortedLists {

    /**
     * Maintain 2 pointer i and j for list a and b, since it is sorted we can just merge it by sequentially iterating both the arrays
     */
    public void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
        ArrayList<Integer> list = new ArrayList<>();
        int i=0,j=0;
        int m = a.size();
        int n = b.size();
        while(i<m && j<n) {
            if(a.get(i)<=b.get(j)) {
                list.add(a.get(i));
                i++;
            } else {
                list.add(b.get(j));
                j++;
            }
        }
        while(i<m) {
            list.add(a.get(i));
            i++;
        }
        while(j<n) {
            list.add(b.get(j));
            j++;
        }

        // Copy the result to a
        a.clear();
        a.addAll(list);
    }

}
