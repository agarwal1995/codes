package personal.arrays;

import java.util.ArrayList;

public class KthRowOfPascalTriangle {

    public ArrayList<Integer> getRow(int A) {
        ArrayList<Integer> previousRow = new ArrayList<>();
        previousRow.add(1);
        if (A == 0) {
            return previousRow;
        }
        previousRow.add(1);
        if(A ==1) {
            return previousRow;
        }
        int i=2;
        while (i<=A) {
            ArrayList<Integer> currentRow = new ArrayList<>();
            currentRow.add(1);
            for(int j=0;j<previousRow.size()-1;j++) {
                currentRow.add(previousRow.get(j) + previousRow.get(j+1));
            }
            currentRow.add(1);
            previousRow = currentRow;
            i++;
        }
        return previousRow;
    }
}
