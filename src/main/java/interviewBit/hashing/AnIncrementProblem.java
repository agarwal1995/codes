package interviewBit.hashing;

import java.util.*;

/**
 * @author raag
 */
public class AnIncrementProblem {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,1));
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(1,2));
        ArrayList<Integer> list3 = new ArrayList<>(Arrays.asList(1,1,2,2));
        System.out.println(new AnIncrementProblem().solve(list));
        System.out.println(new AnIncrementProblem().solve(list2));
        System.out.println(new AnIncrementProblem().solve(list3));
    }

    public ArrayList<Integer> solve(ArrayList<Integer> list) {
        Map<Integer, TreeSet<Integer>> map = new HashMap<>();

        ArrayList<Integer> sol = new ArrayList<>();
        for (int i=0;i<list.size();i++) {
            if (!map.containsKey(list.get(i))) {
                sol.add(list.get(i));
                map.put(list.get(i), new TreeSet<>());
                map.get(list.get(i)).add(i);
                continue;
            }

            int firstIndex = map.get(list.get(i)).first();
            map.get(list.get(i)).remove(firstIndex);
            if (map.get(list.get(i)).isEmpty()) {
                map.remove(list.get(i));
            }
            sol.set(firstIndex, sol.get(firstIndex)+1);
            map.putIfAbsent(list.get(i), new TreeSet<>());
            map.get(list.get(i)).add(i);

            map.putIfAbsent(sol.get(firstIndex), new TreeSet<>());
            map.get(sol.get(firstIndex)).add(firstIndex);
            sol.add(list.get(i));
        }
        return sol;
    }
}
