package interviewBit.backtracking;

import java.util.*;

/**
 * @author raag
 */
public class CombinationSum {

    public static void main(String[] args) {
        new CombinationSum().combinationSum(new ArrayList<>(Arrays.asList(2,3,6,7)), 7);
    }

    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        ArrayList<ArrayList<Integer>> sol = new ArrayList<>();
        Set<Integer> set = new HashSet<>(A);
        A = new ArrayList<>(set);
        Collections.sort(A);
        sum(A, sol, 0, 0, B, new ArrayList<>());
        return sol;
    }

    public void sum(ArrayList<Integer> list, ArrayList<ArrayList<Integer>> res,
                    int i, int sum, int target, List<Integer> currentList) {
        if (sum==target) {
            res.add(new ArrayList<>(currentList));
            return;
        }
        if (i>=list.size() || sum>target) {
            return;
        }
//        for (int k=i;k<list.size();k++) {
            sum = sum + list.get(i);
            currentList.add(list.get(i));
            sum(list, res, i, sum, target, currentList);
            currentList.remove(currentList.size()-1);
            sum = sum - list.get(i);
            sum(list, res, i+1, sum, target, currentList);
//        }
    }
}
