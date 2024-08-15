package interviewBit.backtracking;

import java.util.*;

/**
 * @author raag
 */
public class CombinationSumII {

    public static void main(String[] args) {
        new CombinationSumII().combinationSum(new ArrayList<>(Arrays.asList(8, 10, 6, 11, 1, 16, 8)), 28);
        new CombinationSumII().combinationSum(new ArrayList<>(Arrays.asList(10,1,2,7,6,1,5)), 8);
    }

    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        ArrayList<ArrayList<Integer>> sol = new ArrayList<>();
        Collections.sort(A);
        sum(A, sol, 0, 0, B, new ArrayList<>());
        List<String> solString = new ArrayList<>();
        for (ArrayList<Integer> l:sol) {
            String sbr = l.toString()
                    .replaceAll("\\[","")
                    .replaceAll("]","")
                    .replaceAll("\\s+","");
            solString.add(sbr);
        }
        Set<String> set = new HashSet<>(solString);
        sol.clear();
        for (String s: set) {
            ArrayList<Integer> list = new ArrayList<>();
            String[] line = s.split(",");
            for (String s2:line) {
                list.add(Integer.parseInt(s2));
            }
            sol.add(list);
        }
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
        for (int k=i;k<list.size();k++) {
            sum = sum + list.get(k);
            currentList.add(list.get(k));
            sum(list, res, k+1, sum, target, currentList);
            currentList.remove(currentList.size()-1);
            sum = sum - list.get(k);
        }
    }
}


/*
1 1 2 5 6 7 10
i=0
k=0 sum=1 {1}
    i=1
    k=1 sum=2 {1,1}
        i=2
        k=2 sum=4 {1,1,2}
            i=3
            k=3 sum =9 {1,1,2,5}
            k=3 sum =4 {1,1,2}
        k=2 sum=2 {1,1}
        k=3 sum=7 {1,1,5}
            i=4
            k=4 sum=13 {1,1,5,6}
            k=4 sum=7 {1,1,5}
        k=3 sum=2 {1,1}
        k=3 sum=8 {1,1,6}
 */
