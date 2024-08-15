package interviewBit.arrays;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author raag
 */
public class SpiralOrderMatrix2 {

    public static void main(String[] args) {
        new SpiralOrderMatrix2().generateMatrix(5);
    }

    public ArrayList<ArrayList<Integer>> generateMatrix(int A) {
        Integer[][] matrix = new Integer[A][A];

        int l=0,r=A-1,t=0,b=A-1;

        int x = A*A;

        int c =1;
        while (c<=x) {
            for (int i=l;i<=r;i++) {
                matrix[t][i] = c++;
            }
            t++;
            for (int i=t;i<=b;i++) {
                matrix[i][r] = c++;
            }
            r--;
            for (int i=r;i>=l;i--) {
                matrix[b][i] = c++;
            }
            b--;
            for (int i=b;i>=t;i--) {
                matrix[i][l] = c++;
            }
            l++;
        }
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        for (Integer[] arr: matrix) {
            arrayLists.add(new ArrayList<>());
            arrayLists.get(arrayLists.size()-1).addAll(Arrays.asList(arr));
        }
        return arrayLists;
    }
}
