package sorting;


import java.util.Arrays;
import java.util.Comparator;

public class SortingMain {

    public static void main(String[] args) {
        String[] strings = {"This","is","gonna","be","legendary","and","that's","my","spot"};
        Integer[] integers = {42,23,86,78,43,97,23,12,65};
        SortingUtil.print(strings);
        SortingUtil.print(integers);
        useSelection(strings, integers);
        useInsertion(strings, integers);
        useMergeSort(strings, integers);
    }

    private static void useSelection(String[] strings, Integer[] integers) {
        String[] newString = Arrays.copyOf(strings, strings.length);
        Integer[] copyIntegers = Arrays.copyOf(integers, integers.length);
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort(newString, new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                return s.compareTo(t1);
            }
        });
//      Normal Order
        selectionSort.sort(copyIntegers, (Integer x, Integer y) -> x.compareTo(y));
//        Reverse Order
        selectionSort.sort(copyIntegers, (Integer x, Integer y) -> y.compareTo(x));

        SortingUtil.print(newString);
        SortingUtil.print(copyIntegers);
    }

    private static void useInsertion(String[] strings, Integer[] integers) {
        String[] newString = Arrays.copyOf(strings, strings.length);
        Integer[] copyIntegers = Arrays.copyOf(integers, integers.length);

        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort(newString, (String t1,String t2) -> t1.compareTo(t2));
        insertionSort.sort(copyIntegers, Integer::compareTo);
        insertionSort.sort(integers, Comparator.reverseOrder());

        SortingUtil.print(newString);
        SortingUtil.print(copyIntegers);
    }

    private static void useMergeSort(String[] strings, Integer[] integers) {
        String[] newString = Arrays.copyOf(strings, strings.length);
        Integer[] copyIntegers = Arrays.copyOf(integers, integers.length);

        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(newString, 0, strings.length-1, String::compareTo);
        mergeSort.mergeSort(copyIntegers, 0, integers.length-1, Integer::compareTo);
        SortingUtil.print(newString);
        SortingUtil.print(copyIntegers);
    }
}
