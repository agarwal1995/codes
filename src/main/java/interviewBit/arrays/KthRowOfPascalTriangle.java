package interviewBit.arrays;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author raag
 */
public class KthRowOfPascalTriangle {

    public static void main(String[] args) {
        new KthRowOfPascalTriangle().getRow(5);
    }

    public ArrayList<Integer> getRow(int A) {
        if (A==1) {
            return new ArrayList<>(Arrays.asList(1));
        }
        if (A==2) {
            return new ArrayList<>(Arrays.asList(1,2,1));
        }
        if (A==3) {
            return new ArrayList<>(Arrays.asList(1,3,3,1));
        }


        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1,3,3,1));
        ArrayList<Integer> currRow = new ArrayList<>();
        for (int i=4;i<=A;i++) {
            currRow = new ArrayList<>();
            currRow.add(1);
            for (int j=1;j<arrayList.size();j++) {
                currRow.add(arrayList.get(j-1)+arrayList.get(j));
            }
            currRow.add(1);
            arrayList = currRow;
        }
        return currRow;
    }
}
