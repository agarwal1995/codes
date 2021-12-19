package discussions.pharmeasy;

import java.util.List;

public class FindNumberOfZeroes {

    private static int countZeroes(int[] arr) {
        int n = arr.length;
        int start = 0, end = n-1;

        while (start <= end) {
            int mid = (start + end)/2;
            if(arr[mid] == 1 && (mid == 0 || arr[mid-1]==0)) {
                return mid;
            }
            if(arr[mid] == 1) {
                end = mid-1;
            } else if(mid == n-1) {
                return n;
            } else {
                start = mid +1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr1 = {0,0,0,0,1,1,1,1};
        int[] arr2 = {1,1,1,1};
        int[] arr3 = {0,0,0,0};
        int[] arr4 = {0,1};
        System.out.println(countZeroes(arr1));
        System.out.println(countZeroes(arr2));
        System.out.println(countZeroes(arr3));
        System.out.println(countZeroes(arr4));
    }
}
