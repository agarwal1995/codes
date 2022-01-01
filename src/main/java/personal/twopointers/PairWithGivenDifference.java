package personal.twopointers;

import java.util.ArrayList;
import java.util.Comparator;

public class PairWithGivenDifference {

    public int solve(ArrayList<Integer> A, int B) {
        A.sort(Comparator.naturalOrder());
        int i=0;
        int j=1;
        while (i<A.size() && j<A.size()) {
            int diff = A.get(j) - A.get(i);
            if( diff == B) {
                return 1;
            } else if(diff < B) {
                j++;
            } else {
                i++;
            }
        }
        return 0;
    }

    public static void main(String[] args) {

    }
}
