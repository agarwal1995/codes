package interviewBit.arrays;

import java.util.ArrayList;

public class MinimumLightsToActivate {
    public int solve(ArrayList<Integer> A, int B) {

        Integer[] temp = new Integer[A.size()];

        int c = 0;
        for(int i=0;i<A.size();i++) {
            c = Math.max(c, i-B+1);
            temp[c] = B-1;

            temp[i]=B;
        }
        int n = temp.length;
        for(int i=1;i<n;i++) {
            temp[i] = temp[i-1]-1;
            if(temp[i]==0) {
                return -1;
            }
        }
        return 0;
    }
}
