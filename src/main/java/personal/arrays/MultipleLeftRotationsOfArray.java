package personal.arrays;

import java.util.ArrayList;

public class MultipleLeftRotationsOfArray {

    public ArrayList<ArrayList<Integer>> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        ArrayList<ArrayList<Integer>> sol = new ArrayList<>();

        int n = A.size();
        for (int x : B) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = x; i < n; i++) {
                list.add(A.get(i));
            }
            for (int i = 0; i < x; i++) {
                list.add(A.get(i));
            }
            sol.add(list);
        }
        return sol;
    }
}
