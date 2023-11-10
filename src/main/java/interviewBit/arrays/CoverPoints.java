package interviewBit.arrays;

import java.util.ArrayList;

public class CoverPoints {

    public int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B) {

        int n = A.size();
        int sum = 0;
        for(int i = 1; i<n;i++) {
            int diff = Math.max(Math.abs(B.get(i) - B.get(i-1)),Math.abs(A.get(i) - A.get(i-1)));
            sum = sum + diff;
        }
        return sum;

    }
}
