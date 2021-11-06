package personal.arrays;

public class ProductArrayPuzzle {

    public static long[] productExceptSelf(int nums[], int n) {
        long product = 1;
        int count0 = n;
        for(int i=0;i<n;i++) {
            if (nums[i] !=0) {
                product = product*nums[i];
                count0--;
            }
        }
        long[] sol = new long[n];

        for (int i=0;i<n;i++) {
            if (nums[i] == 0) {
                sol[i] = product;
            } else {
                sol[i] = product / nums[i];
                if(count0==1) {
                    sol[i] =0;
                }
            }
        }
        return sol;
    }

    public static void main(String[] args) {
        int[] nums = {1,0};
        productExceptSelf(nums,2);
    }
}
