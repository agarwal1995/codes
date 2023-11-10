package interviewBit.arrays;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class OccurenceOfEachNumber {
    public ArrayList<Integer> findOccurences(ArrayList<Integer> A) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int x : A) {
            map.putIfAbsent(x, 0);
            map.put(x, map.get(x)+1);
        }
        return new ArrayList<>(map.values());
    }
}
