package interviewBit.arrays;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class WaveArray {
    public ArrayList<Integer> wave(ArrayList<Integer> A) {
        Collections.sort(A);
        for (int i=0;i<A.size()-1;i++) {
            if(i%2==0) {
                if(A.get(i) < A.get(i+1)) {
                    swap(A, i, i+1);
                }
            } else {
                if(A.get(i) > A.get(i+1)) {
                    swap(A, i, i+1);
                }
            }
        }
        return A;
    }

    public static <T> ArrayList<T> swap(ArrayList<T> list, int i, int j) {
        T t = list.get(i);
        list.set(i, list.get(j));
        list.set(j, t);
        return list;
    }
}
