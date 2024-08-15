package interviewBit.bitManipulation;

/**
 * @author raag
 */
public class DivideInteger {
    public static void main(String[] args) {
        new DivideInteger().divide(-2147483648, -1);
    }

    public int divide(int A, int B) {
        boolean positve = (A>=0 && B>=0) || (A<=0 && B<=0);
        if(positve) {
            if ((int)Math.abs(A/B) == Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            }
            return Math.abs(A/B);
        }
        return (A/B);
    }
}
