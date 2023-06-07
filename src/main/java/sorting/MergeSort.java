package sorting;

import java.util.Comparator;

public class MergeSort {

    public <T> void mergeSort(T[] array, int l, int r, Comparator<T> comparator) {
        if (l<r) {
            int mid = l + (r-l)/2;
            mergeSort(array, l, mid, comparator);
            mergeSort(array, mid+1, r, comparator);
            merge(array, l, mid, r, comparator);
        }
    }

    public <T> void merge(T[] array, int l, int mid, int r, Comparator<T> comparator) {
        T[] left = (T[]) new Object[mid-l+1];
        T[] right = (T[]) new Object[r-mid];
        for(int i=0;i<mid-l+1;i++) {
            left[i] = array[l+i];
        }
        for(int i=0;i<r-mid;i++) {
            right[i] = array[mid+i+1];
        }
        int i=0, j=0, k=0;
        while (i<mid-l+1 && j<r-mid) {
            if(comparator.compare(left[i], right[j]) <= 0) {
                array[l+k] = left[i++];
            } else {
                array[l+k] = right[j++];
            }
            k++;
        }
        for(;i<mid-l+1;i++) {
            array[l+k] = left[i];
            k++;
        }
        for(;i<r-mid;i++) {
            array[l+k] = right[i];
            k++;
        }
    }
}
