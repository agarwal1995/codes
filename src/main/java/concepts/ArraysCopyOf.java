package concepts;

import java.util.Arrays;

/**
 * @author raag
 */
public class ArraysCopyOf {

    public static void main(String[] args) {
        Integer[] array = new Integer[]{1,2,3};
        System.out.println(Arrays.toString(array));
        Integer[] arr2 = Arrays.copyOfRange(array, 1, array.length);
        System.out.println(Arrays.toString(arr2));

        Integer[] arr3 = new Integer[]{1};
        System.out.println(Arrays.toString(arr3));
        Integer[] arr4 = Arrays.copyOfRange(array, 1, arr3.length);
        System.out.println(Arrays.toString(arr4));
    }
}
