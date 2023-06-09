package interviewBit.hashing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A number can be broken into different contiguous sub-subsequence parts.
 */
public class ColorfulNumber {
    /**
     * Convert the number to a list, iterate it over in nested loop (i:0-n,j:i-n), and find the product
     * of each contiguous subarray and check in a hashset if it exists or not
     *
     * @param A number to check if that is colorful or not
     * @return 1 if colorful and 0 if not
     */
    public int colorful(int A) {
        List<Integer> list = new ArrayList<>();
        int n=0;
        while (A>0) {
            list.add(A%10);
            A = A/10;
            n++;
        }
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++) {
            int prod = 1;
            for(int j=i;j<n;j++) {
                prod = prod * list.get(j);
                if(set.contains(prod)) {
                    return 0;
                }
                set.add(prod);
            }
        }
        return 1;
    }
}
