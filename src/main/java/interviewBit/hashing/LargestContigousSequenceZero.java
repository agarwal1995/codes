package interviewBit.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LargestContigousSequenceZero {
    public ArrayList<Integer> lszero(ArrayList<Integer> A) {
        ArrayList<Integer> cumulative = new ArrayList<>();
        cumulative.add(A.get(0));
        for(int i=1;i<A.size();i++) {
            cumulative.add(cumulative.get(i-1) + A.get(i));
        }
        Map<Integer, Integer> map = new HashMap<>();

        int max = Integer.MIN_VALUE;
        int minIndex = -1;
        int maxIndex = -1;
        System.out.println(A);
        System.out.println(cumulative);
        for (int i=0;i<A.size();i++) {
            map.putIfAbsent(cumulative.get(i), i);
            if(cumulative.get(i) == 0) {
                minIndex = -1;
                maxIndex = i;
                max = i;
            } else if(map.containsKey(cumulative.get(i)) && (map.get(cumulative.get(i))!=i || i==A.size()-1)) {
                if(max< i-map.get(cumulative.get(i))) {
                    max = i-map.get(cumulative.get(i));
                    minIndex = map.get(cumulative.get(i));
                    maxIndex = i;
                }
            }
        }
        ArrayList<Integer> sol = new ArrayList<>();
        if(maxIndex == -1) {
            return sol;
        }
        sol = new ArrayList<>(A.subList(minIndex+1, maxIndex+1));
        return sol;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(10, -3, -9, -10, 9, -26, 7, -2, -20, -19, -9, 7, 13, -5, -8, -24, -11, 28, 28, 24));
        System.out.println(new LargestContigousSequenceZero().lszero(list));
    }
}
