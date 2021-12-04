package personal.search;

public class BitonicPoint {

    int findMaximum(int[] arr, int n) {
        int start = 0, end = n-1;
        while (start<=end) {
            int mid = (start + end )/2;
            if(mid>0 && mid<n-1 && arr[mid] > arr[mid+1] && arr[mid] > arr[mid-1]) {
                return arr[mid];
            }
            if (mid <n-1 && arr[mid] > arr[mid+1]) {
                end = mid-1;
            } else if (mid == n-1) {
                return arr[mid];
            } else if (mid < n-1 && arr[mid] < arr[mid+1]) {
                start = mid+1;
            }
        }
        return arr[n-1];
    }

    public static void main(String[] args) {
        int[] arr = {1,15,25,45,42,21,17,12,11};
        new BitonicPoint().findMaximum(arr, 9);
    }
}
