package personal.twopointers;

import java.util.List;

public class Array3Pointers {

    public int minimize(final List<Integer> A, final List<Integer> B, final List<Integer> C) {
        int i=0, j=0, k=0;

        int minMax = Integer.MAX_VALUE;

        while (i<A.size() && j<B.size() && k<C.size()) {
            int val1 = Math.abs(B.get(j)-A.get(i));
            int val2 = Math.abs(C.get(k)-B.get(j));
            int val3 = Math.abs(A.get(i)-C.get(k));

            int max = Math.max(val1, Math.max(val2, val3));
            minMax = Math.min(minMax, max);

            if(val1>=val2 && val1>=val3) {
                if(B.get(j) > A.get(i)) {
                    i++;
                } else {
                    j++;
                }
            } else if(val2>=val1 && val2>=val3) {
                if(C.get(k)>B.get(j)) {
                    j++;
                } else {
                    k++;
                }
            } else {
                if(C.get(k)>A.get(i)) {
                    i++;
                } else {
                    k++;
                }
            }
        }
        return minMax;
    }

    public static void main(String[] args) {

    }
}
