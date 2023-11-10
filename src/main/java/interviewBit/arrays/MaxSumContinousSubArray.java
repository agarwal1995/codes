package interviewBit.arrays;

import java.util.List;

public class MaxSumContinousSubArray {
    public int maxSubArray(final List<Integer> A) {
        int maxSum = A.get(0);
        int maxTillNow = A.get(0);
        maxTillNow = Math.max(0, maxTillNow);


        for (int i=1;i<A.size();i++) {
            maxTillNow = maxTillNow + A.get(i);

            maxSum = Math.max(maxSum, maxTillNow);
            if(maxTillNow<=0) {
                maxTillNow=0;
            }
        }
        return maxSum;
    }
}
