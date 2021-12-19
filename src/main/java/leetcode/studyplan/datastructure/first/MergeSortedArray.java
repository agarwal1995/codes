package leetcode.studyplan.datastructure.first;

public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=0,j=0, k=0;
        int[] arr = new int[m+n];
        while(i<m && j<n) {
            if(nums1[i] <= nums2[j]) {
                arr[k++] = nums1[i++];
            } else {
                arr[k++] = nums2[j++];
            }
        }
        while(i<m) {
            arr[k++] = nums1[i++];
        }
        while(j<n) {
            arr[k++] = nums2[j++];
        }
        int p=0;
        for(int x:arr) {
            nums1[p++] = x;
        }
    }
}
