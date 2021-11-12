package personal.arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrderMatrixTwo {

    public ArrayList<ArrayList<Integer>> generateMatrix(int A) {
        ArrayList<Integer> sol = new ArrayList<>();
        int rStart=0,cStart=0;
        int rEnd = A-1;
        int cEnd = A-1;

        int k = 0;
        int t = (rEnd+1)*(cEnd+1);
        ArrayList<ArrayList<Integer>> solution = new ArrayList<>();
        for (int i=0;i<A;i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for(int j=0;j<A;j++) {
                list.add(0);
            }
            solution.add(list);
        }
        while (k<t) {
            for(int i = cStart; i <=cEnd && k<t; i++) {
                solution.get(rStart).set(i, k+1);
//                sol.add(list.get(rStart).get(i));
                k++;
            }
            rStart++;
            for (int i = rStart; i<=rEnd && k<t; i++) {
                solution.get(i).set(cEnd, k+1);
//                sol.add(list.get(i).get(cEnd));
                k++;
            }
            cEnd--;
            for (int i = cEnd; i >=cStart && k<t; i--) {
                solution.get(rEnd).set(i, k+1);
//                sol.add(list.get(rEnd).get(i));
                k++;
            }
            rEnd--;
            for (int i=rEnd; i>= rStart && k<t;i--) {
                solution.get(i).set(cStart, k+1);
//                sol.add(list.get(i).get(cStart));
                k++;
            }
            cStart++;
        }
        return solution;
    }
}
