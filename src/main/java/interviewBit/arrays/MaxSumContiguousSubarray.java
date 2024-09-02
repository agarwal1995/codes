package interviewBit.arrays;

import java.util.List;
import java.util.Map;

/**
 * Find the contiguous subarray within an array, A of length N which has the largest sum.
 *
 * @author raag
 */
public class MaxSumContiguousSubarray {

    /**
     * iterate the list, and keep variable maxSum and sumTillNow
     * maxSum: maxSum found at any particular moment
     * sumTillNow:  sumOf the elements till x index where sum >0,
     *              if <0 then make it 0 and start afresh the list
     * @param A integer array
     * @return maxSubArraySum
     */
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
