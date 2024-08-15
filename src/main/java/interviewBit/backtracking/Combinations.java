package interviewBit.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author raag
 */
public class Combinations {

    public static void main(String[] args) {
        new Combinations().combine(4,2);
    }

    public ArrayList<ArrayList<Integer>> combine(int A, int B) {
        List<Integer> list = new ArrayList<>();
        for (int i=1;i<=A;i++) {
            list.add(i);
        }
        ArrayList<ArrayList<Integer>> sol = new ArrayList<>();
        for (int i=0;i<A;i++) {
            combine(list, sol, i+1,B, new ArrayList<>(Arrays.asList(list.get(i))));
        }
        return sol;
    }

    public void combine(List<Integer> list, ArrayList<ArrayList<Integer>> sol,
                        int i,int b, List<Integer> curList) {
        if (curList.size()==b) {
            sol.add(new ArrayList<>(curList));
            return;
        }
        if (i>=list.size()) {
            return;
        }
        curList.add(list.get(i));
        combine(list, sol, i+1,b, curList);
        curList.remove(curList.size()-1);
        combine(list, sol, i+1,b, curList);

    }
}
