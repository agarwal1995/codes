package interviewBit.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author raag
 */
public class SubarrayWithGivenXOR {

    public static void main(String[] args) {
        System.out.println(new SubarrayWithGivenXOR().solve(new ArrayList<>(Arrays.asList(4,2,2,6,4)), 6));
        System.out.println(new SubarrayWithGivenXOR().solve(new ArrayList<>(Arrays.asList(5,6,7,8,9)), 5));
    }

    public int solve(ArrayList<Integer> A, int B) {

        int n = A.size();
        int[] prefixXor = new int[n];

        prefixXor[0] = A.get(0);
        for (int i=1;i<n;i++) {
            prefixXor[i] = prefixXor[i-1] ^ A.get(i);
        }

        int result = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i=0;i<n;i++) {
            int val = B^prefixXor[i];

            int xor = prefixXor[i];

            if (prefixXor[i]==B) {
                result++;
            }

            result = result + (map.getOrDefault(val, 0));
            if (!map.containsKey(xor)) {
                map.put(xor, 1);
            } else {
                map.put(xor, map.get(xor)+1);
            }

        }
        return result;
    }
}
