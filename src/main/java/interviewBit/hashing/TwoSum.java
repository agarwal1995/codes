package interviewBit.hashing;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 */
public class TwoSum {

    public static void main(String[] args)  throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().trim().split("\\s+");
        List<Integer> inputList = Arrays.stream(input).map(Integer::parseInt).collect(Collectors.toList());
        System.out.println(new TwoSum().twoSum(inputList, -3));
    }

    /**
     * Maintain a map with val to index to check whether target - currentValue exists (already iterated)
     */
    public ArrayList<Integer> twoSum(final List<Integer> A, int B) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<A.size();i++) {
            if(map.containsKey(B-A.get(i))) {
                return new ArrayList<>(Arrays.asList(map.get(B-A.get(i))+1, i+1));
            } else {
                map.putIfAbsent(A.get(i), i);
            }
        }
        return new ArrayList<>();
    }
}
