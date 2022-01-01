package personal.twopointers;

import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicatedFromSortedArray {

    public int removeDuplicates(ArrayList<Integer> a) {
        int i=1,j=1;

        int n = a.size();
        while (j<n) {
            if(a.get(i - 1).equals(a.get(j))) {
                j++;
            } else {
                a.set(i, a.get(j));
                i++;
                j++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(3);
        System.out.println(new RemoveDuplicatedFromSortedArray().removeDuplicates(list));
    }
}
