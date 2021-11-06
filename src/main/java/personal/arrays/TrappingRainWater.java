package personal.arrays;

public class TrappingRainWater {

    static long trappingWater(int arr[], int n) {
        int[] leftMaxArr = new int[n];
        int[] rightMaxArr = new int[n];

        int j = n-2;
        leftMaxArr[0] = arr[0];
        rightMaxArr[n-1] = arr[n-1];
        for (int i =1;i<n-1;i++) {
            leftMaxArr[i] = Math.max(leftMaxArr[i-1], arr[i]);
            rightMaxArr[j] = Math.max(rightMaxArr[j+1], arr[j]);
            j--;
        }
        leftMaxArr[n-1] = Math.max(leftMaxArr[n-2], arr[n-1]);
        rightMaxArr[0] = Math.max(rightMaxArr[1], arr[0]);

        long trappedRainWater = 0;
        for (int i=1;i<n-1;i++) {
            trappedRainWater += Math.max(leftMaxArr[i], rightMaxArr[i]) - arr[i];
        }
        return trappedRainWater;
    }


    public static void main(String[] args) {

    }
}
