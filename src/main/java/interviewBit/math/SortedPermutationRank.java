package interviewBit.math;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author raag
 */
public class SortedPermutationRank {

    public static void main(String[] args) {
        new SortedPermutationRank().findRank("bcad");
    }


    int[] fact = new int[1001];
    int mod = 1000003;

    public int findRank(String A) {

        calculateFactorial();

        char[] temp = A.toCharArray();
        Arrays.sort(temp);
        String sortedString = new String(temp);
        int n = A.length();
        int sum = 0;
        for (int i=0;i<n;i++) {
            int indexInSorted = sortedString.indexOf(A.charAt(i));
            sum = sum + (indexInSorted*fact[n-i-1]);
            if (indexInSorted==0) {
                sortedString = sortedString.substring(1);
            } else if (indexInSorted==sortedString.length()-1) {
                sortedString = sortedString.substring(0, sortedString.length()-1);
            } else {
                sortedString = sortedString.substring(0, indexInSorted)
                        + sortedString.substring(indexInSorted+1);
            }
        }
        return sum+1;
    }

    private void calculateFactorial() {
        fact[1] = 1;
        fact[2] = 2;
        for (int i=3;i<1001;i++) {
            fact[i] = (i*fact[i-1])%mod;
        }
    }


}
