package personal.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {

    public ArrayList<Integer> twoSum(final List<Integer> A, int B) {
        ArrayList<Integer> sol = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<A.size();i++) {
            if(map.containsKey(B-A.get(i))) {
                sol.add((map.get(B-A.get(i))) +1);
                sol.add(i+1);
                return sol;
            }
            map.putIfAbsent(A.get(i), i);
        }
        return sol;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(7);
        list.add(-4);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(-5);
        System.out.println(new TwoSum().twoSum(list, -3));
    }
}
