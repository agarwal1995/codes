package personal.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class CombinationSum {

    static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        ArrayList<ArrayList<Integer>> sol = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>(A);
        A = new ArrayList<>(set);
        Collections.sort(A);
        combinationSumUtil(A, sol, list, 0, 0, B);
        return sol;
    }

    static void combinationSumUtil(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> sol, ArrayList<Integer> list, int index, int sum, int total) {
        if(sum> total || index>= A.size()) {
            return;
        }
        if(sum ==total) {
            sol.add(new ArrayList<>(list));
            return;
        }
        for(int i=index;i<A.size();i++) {
            list.add(A.get(i));
            combinationSumUtil(A, sol, list, i, sum + A.get(i), total);
            list.remove(A.get(i));
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(8);
        list.add(1);
        list.add(8);
        list.add(6);
        list.add(8);
        System.out.println(combinationSum(list, 12));
    }
}
