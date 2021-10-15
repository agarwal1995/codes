package personal.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class CombinationSum2 {

    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        ArrayList<ArrayList<Integer>> sol = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
//        Collections.sort(A);
        combinationSumUtil(set, A, sol, list, 0, 0, B);
        return sol;
    }

    public void combinationSumUtil(Set<String> set, ArrayList<Integer> A, ArrayList<ArrayList<Integer>> sol, ArrayList<Integer> list, int index, int sum, int total) {
        if(sum ==total) {
            ArrayList<Integer> toStore = new ArrayList<>(list);
            Collections.sort(toStore);
            String str = convert(toStore);
            if(!set.contains(str)) {
                sol.add(toStore);
                set.add(str);
            }
            return;
        }
        if(sum> total || index>= A.size()) {
            return;
        }
        for(int i=index;i<A.size();i++) {
            list.add(A.get(i));
            combinationSumUtil(set,A, sol, list, i+1, sum + A.get(i), total);
            list.remove(A.get(i));
        }
    }

    public String convert(ArrayList<Integer> list) {
        StringBuilder sbr = new StringBuilder();
        for(int x : list) {
            sbr.append(x);
        }
        return sbr.toString();
    }


    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(1);
        list.add(2);
        list.add(7);
        list.add(6);
        list.add(1);
        list.add(5);
        CombinationSum2 combinationSum2 = new CombinationSum2();
        System.out.println(combinationSum2.combinationSum(list, 8));
    }
}
