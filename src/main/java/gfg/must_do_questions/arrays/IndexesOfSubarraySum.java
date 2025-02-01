package gfg.must_do_questions.arrays;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * IndexesOfSubarraySum is a class that provides functionality to find the starting and ending
 * indexes of a contiguous subarray within a given array that sums to a specified value.
 *
 * @author raag
 */
public class IndexesOfSubarraySum {

    public static void main(String[] args) {
        int[] array1 = new int[] {1,2,3,7,5};
        int[] array2 = new int[] {1,2,3,4};
        System.out.println(subarraySum(array1, 5,12));
        System.out.println(subarraySum(array2, 4,0));
    }


    public static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        int sumTillNow = 0;

        int startIndex = 0;
        for (int i=0;i<n;i++) {
            sumTillNow = sumTillNow + arr[i];
            if (sumTillNow==s) {
                return new ArrayList<>(Arrays.asList(startIndex+1, i+1));
            }
            while (sumTillNow>s && startIndex<=i) {
                sumTillNow = sumTillNow - arr[startIndex];
                startIndex++;
                if (sumTillNow==s && startIndex<=i) {
                    return new ArrayList<>(Arrays.asList(startIndex+1, i+1));
                }
            }
        }
        return new ArrayList<>(Arrays.asList(-1));
    }
}
