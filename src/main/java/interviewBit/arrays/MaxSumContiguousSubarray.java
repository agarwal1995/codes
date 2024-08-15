package interviewBit.arrays;

import java.util.List;
import java.util.Map;

/**
 * @author raag
 */
public class MaxSumContiguousSubarray {

    public static void main(String[] args) {

    }

    public int maxSubArray(final List<Integer> A) {
        int sumTillNow = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i=0;i<A.size();i++) {
            sumTillNow = sumTillNow + A.get(i);
            maxSum = Math.max(sumTillNow, maxSum);
            if (sumTillNow<0) {
                sumTillNow=0;
            }
        }
        return maxSum;
    }
}
