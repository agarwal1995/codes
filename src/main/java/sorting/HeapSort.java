package sorting;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author raag
 */
public class HeapSort {

    public static void main(String[] args) {

        int[] array = {4,10,3,5,1};

        int n = array.length;
        for (int i=n/2;i>=0;i--) {
            heapify(array,n, i);
        }

        System.out.println(Arrays.toString(array));

        new HeapSort().sort(array, n);
        System.out.println(Arrays.toString(array));

    }

    public void sort(int[] array, int n) {
        if (n<=0) {
            return;
        }
        int tmp = array[0];
        array[0] = array[n-1];
        array[n-1] = tmp;

        n = n-1;
        heapify(array, n, 0);
        sort(array, n);
    }

    public static void heapify(int[] array,int n, int i) {
        if (i>n  || i<0) {
            return;
        }

        int left = 2*i+1;
        int right = 2*i+2;
        int largest = i;

        if(left<n && array[left]>array[largest]) {
            largest = left;
        }

        if (right<n && array[right]> array[largest]) {
            largest = right;
        }

        if (largest!=i) {
            int tmp = array[i];
            array[i] = array[largest];
            array[largest] = tmp;
            heapify(array,n, largest);
        }
    }


}
