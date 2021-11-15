package personal.arrays;

import java.util.ArrayList;
import java.util.Comparator;

public class MaximumUnsortedArray {

    public ArrayList<Integer> subUnsort(ArrayList<Integer> list) {
        ArrayList<Integer> sortedList = new ArrayList<>(list);
        sortedList.sort(Comparator.naturalOrder());
        int n = list.size();
        int i=0;
        for( i=0;i<n;i++) {
            if(!list.get(i).equals(sortedList.get(i))) {
                break;
            }
        }
        if(i==n) {
            return new ArrayList<Integer>() {{
                add(-1);
            }};
        }
        int j = n-1;
        for(j = n-1;j>=i;j--) {
            if(!list.get(i).equals(sortedList.get(i))) {
                break;
            }
        }
        int finalI = i;
        int finalJ = j;
        return new ArrayList<Integer>(){{
            add(finalI);add(finalJ);
        }};
    }

    public static void main(String[] args) {

    }
}
