package personal.hashing;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ArrayPairSumDIvisibility {

    public boolean canPair(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int evenCount = 0;
        for(int x: nums) {
            if (x%k==0) {
                evenCount++;
                continue;
            }
            if(map.containsKey(x%k)) {
                map.put(x%k, map.get(x%k)-1);
                if (map.get(x%k)==0) {
                    map.remove(x%k);
                }
                continue;
            }

            map.putIfAbsent(k-(x%k), 0);
            map.put(k-(x%k), map.get(k-(x%k)) +1);
        }
        return map.isEmpty() && evenCount%2==0;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().trim().split("\\s+");
        int[] arr = new int[line.length];
        for(int i=0;i<line.length;i++) {
            arr[i] = Integer.parseInt(line[i]);
        }
        System.out.println(new ArrayPairSumDIvisibility().canPair(arr, 5));
    }
}
