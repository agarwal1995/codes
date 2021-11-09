package personal.arrays;

import java.util.ArrayList;

public class SetMatrixZeroes {

    public void setZeroes(ArrayList<ArrayList<Integer>> a) {
        int m = a.size();
        int n = a.get(0).size();
        int[] row = new int[m];
        int[] col = new int[n];
        for(int i=0;i<m;i++) {
            for (int j=0; j<n;j++ ) {
                if(a.get(i).get(j) == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        for(int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if (row[i] == 1 || col[j] == 1) {
                    a.get(i).set(j, 0);
                }
            }
        }
    }
}
