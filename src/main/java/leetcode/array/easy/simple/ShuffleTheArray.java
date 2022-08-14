package leetcode.array.easy.simple;

public class ShuffleTheArray {

    public int[] shuffle(int[] nums, int n) {
        int[] array = new int[2*n];
        int k=-1;
        for(int i=0;i<n;i++) {
            array[++k] = nums[i];
            array[++k] = nums[i+n];
        }
        return array;
    }
}
