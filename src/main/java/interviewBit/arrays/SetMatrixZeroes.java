package interviewBit.arrays;

import java.util.ArrayList;

public class SetMatrixZeroes {
    public void setZeroes(ArrayList<ArrayList<Integer>> a) {
        int m = a.size();
        int n = a.get(0).size();
        int[][] tracker = new int[2][Math.max(m,n)];
        for (int i = 0;i<m;i++) {
            for (int j = 0;j<n;j++) {
                if (a.get(i).get(j)==0) {
                    tracker[0][i] = 1;
                    tracker[1][j] = 1;
                }
            }
        }

        for (int i = 0;i<m;i++) {
            for (int j = 0;j<n;j++) {
                if (tracker[0][i]==1 || tracker[1][j]==1) {
                    a.get(i).set(j, 0);
                }
            }
        }
    }
}
