package leetcode.array.easy.simple;

import java.util.ArrayList;
import java.util.List;

public class DecompressRunLengthEncodedList {
    public int[] decompressRLElist(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();

        for(int i=0;i<nums.length;i=i+2) {
            for(int j=0;j<nums[i];j++) {
                list.add(nums[i+1]);
            }
        }
        int[] array = new int[list.size()];
        int k = 0;
        for(int x:list) {
            array[k++] = x;
        }
        return array;
    }
}
