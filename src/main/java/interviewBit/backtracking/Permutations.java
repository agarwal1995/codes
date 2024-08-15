package interviewBit.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author raag
 */
public class Permutations {

    public static void main(String[] args) {
        new Permutations().permute(new ArrayList<>(Arrays.asList(1,2,3)));
    }

    private ArrayList<ArrayList<Integer>> sol = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        rec(A, 0);
        return sol;
    }

    private void rec(ArrayList<Integer> list, int s) {
        if(s==list.size()) {
            sol.add(new ArrayList<>(list));
            return;
        }
        for (int i=s;i<list.size();i++) {
            swap(list, s, i);
            rec(list, s+1);
            swap(list, s, i);
        }
    }

    private void swap(ArrayList<Integer> list, int i, int j) {
        int x = list.get(i);
        list.set(i, list.get(j));
        list.set(j, x);
    }
}
