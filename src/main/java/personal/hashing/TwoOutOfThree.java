package personal.hashing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TwoOutOfThree {

    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {
        Set<Integer> setA = new HashSet<>(A);
        Set<Integer> setB = new HashSet<>(B);
        Set<Integer> setC = new HashSet<>(C);


        ArrayList<Integer> sol = new ArrayList<>();
        for(int x : setA) {
            if (setB.contains(x) || setC.contains(x)) {
                sol.add(x);
                setB.remove(x);
                setC.remove(x);
            }
        }
        for(int y:setB) {
            if(setC.contains(y)) {
                sol.add(y);
            }
        }
        sol.sort(Integer::compareTo);
        return sol;
    }

    public static void main(String[] args) {

    }
}
