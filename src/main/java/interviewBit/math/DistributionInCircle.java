package interviewBit.math;

/**
 * A items are to be delivered in a circle of size B.
 * Find the position where the Ath item will be delivered if we start from a given position C.
 * NOTE: Items are distributed at adjacent positions starting from C.
 * @author raag
 */
public class DistributionInCircle {
    public int solve(int A, int B, int C) {
        return (C+(A%B)-1)%B ;
    }
}
