package interviewBit.hashing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class TwoOutofThree {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {

        Set<Integer> sol = new HashSet<>();

        Set<Integer> set = new HashSet<>(A);
        Set<Integer> set2 = new HashSet<>();
        for (int x: B) {
            if(set.contains(x)) {
                sol.add(x);
            } else {
                set2.add(x);
            }
        }
        set.addAll(set2);
        for (int x: C) {
            if(set.contains(x)) {
                sol.add(x);
            }
        }
        ArrayList<Integer> list = new ArrayList<>(sol);
        Collections.sort(list);
        return list;
    }
}
