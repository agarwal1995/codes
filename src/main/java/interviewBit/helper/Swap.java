package interviewBit.helper;

import java.util.ArrayList;

/**
 * Helper class to swap the elements
 */
public class Swap {

    /**
     * Generic method to swap elements of an arraylist
     */
    public static <T> ArrayList<T> swap(ArrayList<T> list, int i, int j) {
        T t = list.get(i);
        list.set(i, list.get(j));
        list.set(j, t);
        return list;
    }
}
