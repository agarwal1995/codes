package interviewBit.bitManipulation;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author raag
 */
public class XoringSubarrays {

    public static void main(String[] args) {
        System.out.println(new XoringSubarrays().solve(new ArrayList<>(Arrays.asList(3,4,5))));
    }

    public int solve(ArrayList<Integer> A) {
        int xor = 0;

        for (int i=0;i<A.size();i++) {
            int c = (A.size()-i) * (i+1);

            if (c%2!=0) {
                xor = xor ^ A.get(i);
            }
        }
        return xor;
    }
}
