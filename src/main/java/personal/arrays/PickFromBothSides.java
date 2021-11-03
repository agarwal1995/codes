package personal.arrays;

import java.util.ArrayList;

public class PickFromBothSides {
    public int solve(ArrayList<Integer> A, int B) {
        int n = A.size();
        int maxSum = 0;
        int sumStart = 0;
        int sumEnd = 0;

        for(int i=0;i<B;i++) {
            sumStart = sumStart + A.get(i);
        }

        maxSum = sumStart;
        int k=n-1;
        for(int i=0;i<B;i++) {
            sumStart = sumStart - A.get(B-i-1) + A.get(k);
            k--;
            maxSum = Math.max(maxSum, sumStart);
        }
        return maxSum;


    }
}
