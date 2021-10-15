package personal.backtracking;

import java.util.*;

public class UniquePermutations {

    public static void main(String[] args) {
        UniquePermutations uniquePermutations = new UniquePermutations();
        System.out.println(uniquePermutations.permute(new ArrayList<Integer>(Arrays.asList(1,2,2))));
    }

    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        Set<String> set = new HashSet<>();
        ArrayList<ArrayList<Integer>> sol = new ArrayList<>();
        permuteUtil(0, A.size()-1, sol, A, set);
        return sol;
    }

    public void permuteUtil(int i, int j, ArrayList<ArrayList<Integer>> sol, ArrayList<Integer> obj, Set<String> set) {
        if(i==j) {
            if(!set.contains(obj.toString())) {
                sol.add(new ArrayList<>(obj));
                set.add(obj.toString());
            }
            return;
        }

        for(int a=i;a<=j;a++) {
            if(a!=i && obj.get(a).compareTo(obj.get(i)) == 0) {
                continue;
            }
            swap(obj, a, i);
            permuteUtil(i+1, j, sol, obj, set);
            swap(obj, a, i);
        }
    }

    public void swap(List<Integer> list, int i, int j) {
        int x = list.get(i);
        list.set(i, list.get(j));
        list.set(j, x);
    }
}
