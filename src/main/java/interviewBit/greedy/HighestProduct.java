package interviewBit.greedy;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Given an array A, of N integers A.
 * Return the highest product possible by multiplying 3 numbers from the array.
 * @author raag
 */
public class HighestProduct {

    public static void main(String[] args) {

    }

    public int maxp3(ArrayList<Integer> A) {
        A.sort(Comparator.reverseOrder());
        int n = A.size();
        int withMaxNumbers = A.get(0) * A.get(1) * A.get(2);
        int withLastNumbers = A.get(0) * A.get(n-1) * A.get(n-2);
        return Math.max(withMaxNumbers, withLastNumbers);
    }

}
