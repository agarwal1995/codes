package interviewBit.hashing;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Given a stream of numbers A. On arrival of each number, you need to increase its first occurrence by 1 and include this in the stream.
 * Return the final stream of numbers.
 */
public class IncrementProblem {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().trim().split("\\s+");
        ArrayList<Integer> list = Arrays.stream(input).map(Integer::parseInt).collect(Collectors.toCollection(ArrayList::new));
        System.out.println(new IncrementProblem().solve(list));
    }

    /**
     * Maintain a map of value to set of sorted indexes
     * add new element to result everyTime
     * update result for the idx if found
     * add/update values to the map
     */
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>();

        int i=-1;
        Map<Integer, TreeSet<Integer>> valToFirstIndex = new HashMap<>();
        for(int x : A) {
            i++;
            result.add(x);
            if(!valToFirstIndex.containsKey(x)) {
                valToFirstIndex.putIfAbsent(x, new TreeSet<>());
                valToFirstIndex.get(x).add(i);
                continue;
            }
            TreeSet<Integer> idxList = valToFirstIndex.remove(x);
            int idx = idxList.first();
            result.set(idxList.first(), result.get(idxList.first())+1);

            // Put new Element in Map
            idxList.remove(idxList.first());
            if(!idxList.isEmpty()) {
                idxList.add(i);
                valToFirstIndex.putIfAbsent(x, idxList);
            } else {
                valToFirstIndex.putIfAbsent(x, new TreeSet<>());
                valToFirstIndex.get(x).add(i);
            }

            // Put incremented element  in map
            valToFirstIndex.putIfAbsent(result.get(idx), new TreeSet<>());
            valToFirstIndex.get(result.get(idx)).add(idx);
        }
        return result;
    }
}
