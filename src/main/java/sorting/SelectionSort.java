package sorting;

import java.util.Comparator;

public class SelectionSort {

    public <T>  void sort(T[] array, Comparator<T> comparator) {
        int n = array.length;
        int minIndex;
        for(int i=0;i<n;i++) {
            minIndex = i;
            for (int j=i+1;j<n;j++) {
                if(comparator.compare(array[minIndex], array[j]) > 0) {
                    minIndex = j;
                }
            }
            if(i!=minIndex) {
                SortingUtil.swap(array, i, minIndex);
            }
        }
    }
}
