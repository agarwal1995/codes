package personal.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LargestNumber {

    public String largestNumber(final List<Integer> A) {
        Collections.sort(A, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String str1 = o1+""+o2;
                String str2 = o2+""+o1;
                if (str1.compareTo(str2) < 0) {
                    return 1;
                }
                return -1;
            }
        });
        StringBuilder sbr = new StringBuilder();
        if(A.get(0) == 0) {
            return "0";
        }
        for(int x : A) {
            sbr.append(x);
        }
        return sbr.toString();
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(30);
        list.add(34);
        list.add(5);
        list.add(9);
        System.out.println(new LargestNumber().largestNumber(list));
    }
}
