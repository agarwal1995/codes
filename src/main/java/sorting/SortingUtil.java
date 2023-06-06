package sorting;

public class SortingUtil {

    public static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static <T> void print(T[] array) {
        for (T val : array) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
