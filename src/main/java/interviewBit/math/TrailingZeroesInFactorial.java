package interviewBit.math;

/**
 * Given an integer A, return the number of trailing zeroes in A!.
 * @author raag
 */
public class TrailingZeroesInFactorial {

    /**
     * Divide the number by 5 until it becomes 0
     * a zero is formed by multiple 2*5, so calculating numbers of 5 that will come
     */
    public int trailingZeroes(int A) {
        int res = 0;
        while(A!=0) {
            res = res + A/5;
            A = A/5;
        }
        return res;
    }
}
