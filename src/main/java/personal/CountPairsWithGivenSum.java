package personal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class CountPairsWithGivenSum {

    private static int getPairsCount(int[] arr, int n, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        int count =0;
        for (int i=0;i<n;i++) {
            if (arr[i]>k) {
                continue;
            }
            if (map.containsKey(k-arr[i])) {
                count = count + map.get(k-arr[i]);
            }
            map.putIfAbsent(arr[i], 0);
            map.put(arr[i], map.get(arr[i]) + 1);
        }
        return count;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().trim().split("\\s+");
        int n = Integer.parseInt(line[0]);
        int k = Integer.parseInt(line[1]);

        String[] line1 = br.readLine().trim().split("\\s+");
        int[] arr = new int[n];
        for (int i =0;i<n;i++) {
            arr[i] = Integer.parseInt(line1[i]);
        }

        System.out.println(getPairsCount(arr, n, k));
    }
}
