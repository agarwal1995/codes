package interviewBit.hashing;

import java.util.*;

/**
 * @author raag
 */
public class FourSum {

    public static void main(String[] args) {
        new FourSum().fourSum(new ArrayList<>(Arrays.asList(1,0,-1,0,-2,2)), 0);
    }

    public ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> list, int B) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        Collections.sort(list);
        for (int i=0;i<list.size();i++) {
            for (int j=i+1;j<list.size();j++) {
                Set<Integer> set = new HashSet<>();
                int sum = (list.get(i) + list.get(j));
                for (int k=j+1;k<list.size();k++) {
                    if (set.contains(B-list.get(k))) {
                        res.add(new ArrayList<>(Arrays.asList(list.get(i), list.get(j), B-list.get(k), list.get(k))));
                    }
                    set.add(list.get(k));
                }
            }
        }
        return res;
    }
}
