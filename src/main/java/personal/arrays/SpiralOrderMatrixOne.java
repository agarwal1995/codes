package personal.arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrderMatrixOne {

    public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> list) {
        ArrayList<Integer> sol = new ArrayList<>();
        int rStart=0,cStart=0;
        int rEnd = list.size() - 1;
        int cEnd = list.get(0).size() - 1;

        int k = 0;
        int t = (rEnd+1)*(cEnd+1);
        while (k<t) {
            for(int i = cStart; i <=cEnd && k<t; i++) {
                sol.add(list.get(rStart).get(i));
                k++;
            }
            rStart++;
            for (int i = rStart; i<=rEnd && k<t; i++) {
                sol.add(list.get(i).get(cEnd));
                k++;
            }
            cEnd--;
            for (int i = cEnd; i >=cStart && k<t; i--) {
                sol.add(list.get(rEnd).get(i));
                k++;
            }
            rEnd--;
            for (int i=rEnd; i>= rStart && k<t;i--) {
                sol.add(list.get(i).get(cStart));
                k++;
            }
            cStart++;
        }
        return sol;
    }
}
