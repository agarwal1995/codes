package interviewBit.backtracking;

import java.util.*;

/**
 * @author raag
 */
public class SubsetsII {

    public static void main(String[] args) {
        new SubsetsII().subsetsWithDup(new ArrayList<>(Arrays.asList(5,4)));
        new SubsetsII().subsetsWithDup(new ArrayList<>(Arrays.asList(1,2,2)));
    }

    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> sol = new ArrayList<>();
        Collections.sort(A);
        rec(A, sol, new ArrayList<>(), 0);
        List<String> solString = new ArrayList<>();
        for (ArrayList<Integer> l:sol) {
            String sbr = l.toString()
                    .replaceAll("\\[","")
                    .replaceAll("]","")
                    .replaceAll("\\s+","");
            solString.add(sbr);
        }
        Set<String> set = new LinkedHashSet<>(solString);
        sol.clear();
        for (String s: set) {
            ArrayList<Integer> list = new ArrayList<>();
            String[] line = s.split(",");
            for (String s2:line) {
                if (!s2.equalsIgnoreCase(""))
                list.add(Integer.parseInt(s2));
            }
            sol.add(list);
        }
        return sol;
    }

    private void rec(ArrayList<Integer> list, ArrayList<ArrayList<Integer>> sol,
                     List<Integer> curList, int i) {
        sol.add(new ArrayList<>(curList));
        for (int j=i;j<list.size();j++) {
            curList.add(list.get(j));
            rec(list, sol, curList, j+1);
            curList.remove(curList.size()-1);
        }
    }
}
