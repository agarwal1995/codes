package sorting;

public class MergeSort {

    public <T> void sort(T[] array) {
        int n = array.length;
        int l = 0;
        int r = n-1;
    }

    public <T> void mergeSort(T[] array, int l, int r) {
        while (l<r) {
            int mid = l + (r-l)/2;
            mergeSort(array, l, mid);
            mergeSort(array, mid+1, r);
        }
    }
}
