package personal.search;

public class SearchInsertPosition {

    static int searchInsertK(int arr[], int n, int k) {
        int i=0, j=n-1;
        if(k<arr[0]) {
            return i;
        }
        if(k>arr[n-1]) {
            return j+1;
        }
        while (i<=j) {
            int mid = (i+j)/2;
            if(arr[mid] == k) {
                return mid;
            }
            if(mid+1<n && arr[mid] <k && arr[mid+1]>k) {
                return mid+1;
            }
            if(arr[mid] < k) {
                i = mid +1;
            }else {
                j = mid-1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {

    }
}
