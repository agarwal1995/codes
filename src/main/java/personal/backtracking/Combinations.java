package personal.backtracking;

import java.util.*;

public class Combinations {

    public ArrayList<ArrayList<Integer>> combine(int A, int B) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        combineUtil(list, 1, A,B, new ArrayList<>());
        return list;
    }

    public void combineUtil(ArrayList<ArrayList<Integer>> sol, int start, int n,int b, ArrayList<Integer> temp) {
        if(temp.size()==b) {
            sol.add(new ArrayList<>(temp));
            return;
        }
        for(int i=start;i<=n;i++) {
            temp.add(i);
            combineUtil(sol, i+1, n,b, temp);
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] args) {
        Combinations c = new Combinations();
        System.out.println(c.combine(4,2));
    }
}
