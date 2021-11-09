package discussions.vymo;

import java.util.HashMap;
import java.util.Map;

public class PositiveNegativeArrayElementSum {
    private static int count = 0;
    void methodUtil(int sum, int[] arr, int currSum, int i, int n) {
        if(i==n) {
            count += currSum == sum ? 1 : 0;
            return;
        }
        methodUtil(sum, arr, currSum + arr[i], i+1, n);
        methodUtil(sum, arr, currSum - arr[i], i+1, n);
    }

    void method(int[] arr, int sumToBe) {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(arr[0], 1);
        map.put(-arr[0], 1);
        for(int i=1;i<arr.length;i++) {
            Map<Integer, Integer> map2 = new HashMap<>();
            for(Integer key : map.keySet()) {
                map.putIfAbsent(arr[i] + key, 0);
                map.put(arr[i] + key, map.get(arr[i] + key) + 1);
                map.putIfAbsent(-arr[i] + key, 0);
                map.put(-arr[i] + key, map.get(-arr[i] + key) + 1);
            }
            map = map2;
        }
        map.get(sumToBe);
    }
}
