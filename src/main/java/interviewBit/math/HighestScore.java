package interviewBit.math;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HighestScore {
    public static void main(String[] args) {
        ArrayList<ArrayList<String>> A = new ArrayList<>();
        A.add(new ArrayList<>());
        A.add(new ArrayList<>());
        A.get(0).add("fqyh");
        A.get(0).add("79");
        A.get(1).add("fqyh");
        A.get(1).add("12");
        System.out.println(new HighestScore().highestScore(A));
    }
    // When initializing an array while declaration don't give the size
    public int highestScore(ArrayList<ArrayList<String>> A) {
        Map<String, Integer[]> studentSum = new HashMap<>();
        for (ArrayList<String> list:A) {
            studentSum.putIfAbsent(list.get(0), new Integer[]{0,0});
            Integer[] array = studentSum.get(list.get(0));
            array[0] = array[0] + Integer.parseInt(list.get(1));
            array[1] =array[1]+1;
            studentSum.put(list.get(0), array);
        }
        int maxAvg= 0;
        for (Integer[] val : studentSum.values()) {
            maxAvg = Math.max(maxAvg, (int)val[0]/val[1]);
        }
        return maxAvg;
    }
}
