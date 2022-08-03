package personal.twopointers;

import java.util.ArrayList;

public class MaximumOnesAfterModification {

    public int solve(ArrayList<Integer> A, int B) {
        int max = 0;
        int convertTo1 = 0;
        int i = 0;
        int j = 0;
        int n = A.size();
        while (j<n) {
            if(A.get(j) == 1) {
                max = Math.max(max, j-i+1);
                j++;
                continue;
            }
            if(B>convertTo1) {
                max = Math.max(max, j-i+1);
                j++;
                convertTo1++;
            } else {
                if(A.get(i)!=1) {
                    convertTo1--;
                }
                i++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MaximumOnesAfterModification m = new MaximumOnesAfterModification();
        ArrayList<Integer> list = new ArrayList();
        list.add(1);
        list.add(0);
        list.add(0);
        list.add(1);
        list.add(0);
        list.add(1);
        list.add(0);
        list.add(1);
        list.add(0);
        list.add(1);
        System.out.println(m.solve(list, 2));
        ;
    }
}
