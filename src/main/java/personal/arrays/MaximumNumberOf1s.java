package personal.arrays;

public class MaximumNumberOf1s {


    int findZeroes(int arr[], int n, int m) {
        int zeroes = m;

        int i=0,j=0,max = 0;

        while (i<n && j<n) {
            if(arr[j] == 1) {
                max = Math.max(max, j-i+1);
            } else {
                if(zeroes == 0) {
                    if (arr[i] == 0) {
                        zeroes++;
                    }
                    i++;
                    continue;
                } else {
                    zeroes --;
                }
                max = Math.max(max, j-i+1);
            }
            j++;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1};
        System.out.println(new MaximumNumberOf1s().findZeroes(arr, 11, 2));
    }
}
