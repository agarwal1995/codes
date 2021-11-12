package personal.arrays;

import java.util.ArrayList;
import java.util.List;

public class FindDuplicateInArraySingleStream {

    public int repeatedNumber(final List<Integer> list) {
        int repeatedNumber = -1;
        int n = list.size();
        int[] array = new int[n];
        for (int i = 0; i<n; i++) {
            int x = Math.abs(list.get(i)) - 1;
            if (array[x] < 0) {
                return x+1;
            }
            array[x] = -(list.get(x));
        }
        System.out.println(list);
        return repeatedNumber;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(4);
        list.add(1);
        list.add(4);
        list.add(1);
        System.out.println(new FindDuplicateInArraySingleStream().repeatedNumber(list));
    }

}
