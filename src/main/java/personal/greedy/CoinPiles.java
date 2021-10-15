package personal.greedy;

import java.util.*;

public class CoinPiles {

    static int minSteps(int[] A, int N, int K) {
        Map<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int a:A) {
            map.putIfAbsent(a, 0);
            map.put(a, map.get(a) + 1);
            max = Math.max(max, a);
            min = Math.min(min, a);
        }
        int sol = 0;
        for(Map.Entry<Integer, Integer> m : map.entrySet()) {
            if (m.getKey()<=K && Math.abs(m.getKey() - min) <= K) {
                break;
            }
            sol = sol + (m.getKey() - min - K) * m.getValue();
        }
        return sol;
    }

    public static void main(String[] args) {
        int[] array = {1,3};
        System.out.println(minSteps(array, array.length, 1));
    }
}
