package interviewBit.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author raag
 */
public class DistinctNumbersInWindow {

    public static void main(String[] args) {
        System.out.println(new DistinctNumbersInWindow().dNums(new ArrayList<>(Arrays.asList(1,2,1,3,4,3)), 3));
        System.out.println(new DistinctNumbersInWindow().dNums(new ArrayList<>(Arrays.asList(1,1,2,2)), 1));
    }

    public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<B && i<A.size();i++) {
            map.putIfAbsent(A.get(i), 0);
            map.put(A.get(i), map.get(A.get(i))+1);
        }

        ArrayList<Integer> solution = new ArrayList<>();
        solution.add(map.size());
        for (int i=B;i<A.size();i++) {
            int toRemove = A.get(i-B);
            if(map.get(toRemove)>1) {
                map.put(toRemove, map.get(toRemove)-1);
            } else {
                map.remove(toRemove);
            }
            map.putIfAbsent(A.get(i), 0);
            map.put(A.get(i), map.get(A.get(i))+1);
            solution.add(map.size());
         }
        return solution;
    }
}
