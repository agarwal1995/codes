package personal.backtracking;

import java.util.*;

public class Subsets {
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> sol = new ArrayList<>();
        Collections.sort(A);
        subsetsUtil(0,A.size(),A,new ArrayList<>(),sol);
        return sol;
    }

    public void subsetsUtil(int s,int n,ArrayList<Integer> A, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> sol) {
        if(s>n) {
            return;
        }
        sol.add(new ArrayList<>(temp));
        for(int i=s;i<n;i++) {
            temp.add(A.get(i));
            subsetsUtil(i+1,n,A,temp, sol);
            temp.remove(temp.size()-1);
        }
    }
}
