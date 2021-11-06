package personal.arrays;

import java.util.Arrays;

public class ThreeSumClosest {

    static int threeSumClosest(int[] array, int target) {
        int n = array.length;
        int maxClosestSum = Integer.MIN_VALUE;
        int closestDiff = Integer.MAX_VALUE;
        Arrays.sort(array);
        for (int i=0;i<n-2;i++) {
            int sum;
            int j=i+1,k=n-1;
            while (j<k) {
                sum = array[i] + array[j] + array[k];
                if(sum == target) {
                    return sum;
                }
                if (sum>target) {
                    k--;
                } else {
                    j++;
                }

                if (Math.abs(sum-target) < closestDiff) {
                    maxClosestSum = Math.max(sum, maxClosestSum);
                    closestDiff = Math.abs(sum-target);
                } else if (Math.abs(sum - target) == closestDiff) {
                    maxClosestSum = Math.max(sum, maxClosestSum);
                }
            }
        }
        return maxClosestSum;
    }

    public static void main(String[] args) {
//        int A[] = {-7,9,8,3,1,1};
        int[] A = {20,99, 61, 94, 64, 29, 10, 35, 90, 49};
        System.out.println(threeSumClosest(A,188 ));
    }
}
