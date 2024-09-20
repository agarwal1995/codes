package gfg.must_do_questions.arrays;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author raag
 */
public class CountTriplets {

    int countTriplet(int arr[], int n) {
        Arrays.sort(arr);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<n;i++) {
            map.putIfAbsent(arr[i], 0);
            map.put(arr[i], map.get(arr[i]) + 1);
        }
        int count = 0;
        for (int i=0;i<n-2;i++) {
            for (int j=i+1;j<n-1;j++) {
                int sum = arr[i] + arr[j];
                count = count + map.getOrDefault(sum, 0);
            }
        }
        return count;
    }
}
