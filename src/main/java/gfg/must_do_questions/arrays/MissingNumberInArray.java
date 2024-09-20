package gfg.must_do_questions.arrays;

import java.util.Arrays;

/**
 * @author raag
 */
public class MissingNumberInArray {

    // Note that the size of the array is n-1
    int missingNumber(int n, int[] arr) {
        long sumToNTerms = ((long) n *( n+1))/2;
        long sumOfArray = Arrays.stream(arr).sum();
        return (int)(sumToNTerms-sumOfArray);
    }
}
