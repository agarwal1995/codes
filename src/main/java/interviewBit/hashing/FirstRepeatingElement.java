package interviewBit.hashing;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * We need to find the element that occurs more than once and whose index of first occurrence is smallest.
 */
public class FirstRepeatingElement {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().trim().split("\\s+");
        List<Integer> list = Arrays.stream(str).map(Integer::parseInt).collect(Collectors.toList());
        new FirstRepeatingElement().solve(new ArrayList<>(list));
    }

    /**
     * Store the value in a map of as key:number,value:index
     * Maintain a minIndex var which store the min index of the repeated element
     * @param A array of integers
     * @return first duplicate element
     */
    public int solve(ArrayList<Integer> A) {
        int minIndex = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<A.size();i++) {
            if(map.containsKey(A.get(i))) {
                minIndex = Math.min(minIndex, map.get(A.get(i)));
            } else {
                map.putIfAbsent(A.get(i), i);
            }
        }
        if(minIndex!=Integer.MAX_VALUE) {
            return A.get(minIndex);
        }
        return -1;
    }
}
