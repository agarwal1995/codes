package interviewBit.bitManipulation;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author raag
 */
public class MinXorValue {

    public static void main(String[] args) {

    }

    public int findMinXor(ArrayList<Integer> A) {
        A.sort(Comparator.naturalOrder());
        int minXor = Integer.MAX_VALUE;
        for (int i=0;i<A.size()-1;i++) {
            minXor = Math.min(minXor, A.get(i)^A.get(i+1));
        }
        return minXor;
    }
}
