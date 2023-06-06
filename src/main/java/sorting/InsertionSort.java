package sorting;

import java.util.Comparator;

public class InsertionSort {

    public <T> void sort(T[] array, Comparator<T> comparator) {
        int n = array.length;
        for(int i=0;i<n;i++) {
            for(int j=i;j>0;j--) {
                if(comparator.compare(array[j], array[j-1]) < 0) {
                    SortingUtil.swap(array, j, j-1);
                    continue;
                }
                break;
            }
//            SortingUtil.print(array);
        }
        SortingUtil.print(array);
    }
}
