package gfg.must_do_questions.arrays;

public class TrappingRainWater {

    public static void main(String[] args) {

    }

    public int maxWater(int arr[]) {
        int[] leftMax = new int[arr.length];
        int[] rightMax = new int[arr.length];

        for (int i=0,j=arr.length-1;i<arr.length;i++,j--){
            if (i==0) {
                leftMax[i] = arr[i];
                rightMax[j] = arr[j];
            } else {
                leftMax[i] = Math.max(leftMax[i-1], arr[i]);
                rightMax[j] = Math.max(rightMax[j+1], arr[j]);
            }
        }

        int waterTrapped = 0;

        for (int i=0;i<arr.length;i++) {
            waterTrapped = waterTrapped + Math.min(leftMax[i], rightMax[i]) - arr[i];
        }
        return waterTrapped;
    }
}
