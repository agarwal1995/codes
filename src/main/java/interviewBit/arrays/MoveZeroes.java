package interviewBit.arrays;

import java.util.ArrayList;

public class MoveZeroes {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        int i=0;
        int j=1;
        int n = A.size();
        while(i<n && j<n) {
            if(A.get(j)!=0 && A.get(i)==0) {
                int t = A.get(i);
                A.set(i, A.get(j));
                A.set(j,0);
                j++;i++;
            }
            else if(A.get(i)!=0) {
                i++;j++;
            } else {
                j++;
            }
        }
        return A;
    }
}
