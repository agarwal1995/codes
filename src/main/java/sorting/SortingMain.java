package sorting;

import java.util.Comparator;

public class SortingMain {

    public static void main(String[] args) {
        String[] strings = {"This","is","gonna","be","legendary","and","that's","my","spot"};
        Integer[] integers = {42,23,86,78,43,97,23,12,65};
        SortingUtil.print(strings);
        SortingUtil.print(integers);
//        useSelection(strings, integers);
//        useInsertion(strings, integers);
//        useMergeSort(strings, integers);
    }

    private static void useSelection(String[] strings, Integer[] integers) {
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                return s.compareTo(t1);
            }
        });
//      Normal Order
        selectionSort.sort(integers, (Integer x, Integer y) -> x.compareTo(y));
//        Reverse Order
        selectionSort.sort(integers, (Integer x, Integer y) -> y.compareTo(x));
    }

    private static void useInsertion(String[] strings, Integer[] integers) {
        InsertionSort insertionSort = new InsertionSort();
        System.out.println("Insertion Sort");
        insertionSort.sort(strings, (String t1,String t2) -> t1.compareTo(t2));
        insertionSort.sort(integers, Integer::compareTo);
        insertionSort.sort(integers, Comparator.reverseOrder());
    }

    private static void useMergeSort(String[] strings, Integer[] integers) {
        MergeSort mergeSort = new MergeSort();
        System.out.println("Merge Sort");
        mergeSort.mergeSort(strings, 0, strings.length-1, String::compareTo);
        mergeSort.mergeSort(integers, 0, integers.length-1, Integer::compareTo);
        SortingUtil.print(strings);
        SortingUtil.print(integers);
    }
}
