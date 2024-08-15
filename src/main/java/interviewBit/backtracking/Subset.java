package interviewBit.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author raag
 */
public class Subset {

    public static void main(String[] args) {
        new Subset().subsets(new ArrayList<>(Arrays.asList(1,2,3)));
        System.out.println(new Subset().subsets(new ArrayList<>(Arrays.asList(15,20,12,19,4))));
    }

    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        Collections.sort(A);
        ArrayList<ArrayList<Integer>> sols = new ArrayList<>();
        subsets(A, 0, A.size(), new ArrayList<>(), sols);
        return sols;
    }

    private void subsets(ArrayList<Integer> input, int s, int n, ArrayList<Integer> currentList,
                         ArrayList<ArrayList<Integer>> sol) {
        sol.add(new ArrayList<>(currentList));
        if (s>=n) {
            return;
        }
        for (int i=s;i<n;i++) {
            currentList.add(input.get(i));
            subsets(input, i + 1, n, currentList, sol);
            currentList.remove(currentList.size() - 1);
        }
    }
}
