package interviewBit.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author raag
 */
public class CountingSubarrays {
    public static void main(String[] args) {
        new CountingSubarrays().solve(new ArrayList<>(Arrays.asList(8, 5, 1, 10, 5, 9, 9, 3, 5, 6, 6, 2, 8, 2, 2, 6, 3, 8, 7, 2, 5, 3, 4, 3, 3, 2, 7, 9, 6, 8, 7, 2, 9, 10, 3, 8, 10, 6, 5, 4, 2, 3, 4, 4, 5, 2, 2, 4, 9, 8, 5)),32);
        new CountingSubarrays().solve(new ArrayList<>(Arrays.asList(8, 5, 1, 10, 5, 9)),32);
        new CountingSubarrays().solve(new ArrayList<>(Arrays.asList(1,11,2,3,15)),10);
        new CountingSubarrays().solve(new ArrayList<>(Arrays.asList(2,5,6)),10);
    }

//    public int solve(ArrayList<Integer> A, int B) {
//
//    }

    public int solve(ArrayList<Integer> A, int B) {
        int count = 0;
        int n = A.size();
        int currentSum = 0;

        for (int i=0;i<n;i++) {
            currentSum = A.get(i);
            if (currentSum<B) {
                count++;
            } else {
                continue;
            }
            for (int j=i+1;j<n;j++) {
                currentSum += A.get(j);
                if (currentSum<B) {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }
}
