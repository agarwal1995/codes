package interviewBit.twoPointers;

import java.util.Arrays;
import java.util.List;

/**
 * @author raag
 */
public class ArrayThreePointers {

    public static void main(String[] args) {
        new ArrayThreePointers().minimize(
                Arrays.asList(1,4,10),
                Arrays.asList(2,15,20),
                Arrays.asList(10,12)
        );
    }

    public int minimize(final List<Integer> A, final List<Integer> B, final List<Integer> C) {
        int maxMin = Integer.MAX_VALUE;

        int m = A.size();
        int n = B.size();
        int p = C.size();

        int i=0,j=0,k=0;
        while (i<m && j<n && k<p) {
            int max1 = Math.abs(A.get(i)-B.get(j));
            int max2 = Math.abs(B.get(j)-C.get(k));
            int max3 = Math.abs(C.get(k)-A.get(i));

            maxMin = Math.min(maxMin, Math.max(max2, Math.max(max3, max1)));

            boolean lastIndex = false;

            if (A.get(i).compareTo(B.get(j)) < 0) {
                if (A.get(i).compareTo(C.get(k)) < 0) {
                    i++;
                } else {
                    k++;
                }
            } else {
                if (B.get(j).compareTo(C.get(k)) < 0) {
                    j++;
                } else {
                    k++;
                }
            }
        }
        return maxMin;
    }
}
