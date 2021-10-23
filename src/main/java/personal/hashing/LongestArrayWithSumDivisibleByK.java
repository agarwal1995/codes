package personal.hashing;

import java.util.HashMap;
import java.util.Map;

public class LongestArrayWithSumDivisibleByK {

    int longSubarrWthSumDivByK(int a[], int n, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int lastIndexWithRemainder = -1;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int index = 0;
        for(int x:a) {
            sum = sum +x;
            int mod = ((sum%k) + k)%k;
            if(mod==0) {
                max = index+1;
                index++;
                continue;
            }
            if(map.containsKey(mod)) {
                max = Math.max(max, index - map.get(mod));
            }
            map.putIfAbsent(mod, index);
            index++;
        }
        return Math.max(0, max);
    }
    public static void main(String[] args) {
//        int[] arr = {1, 2, -2, 2, 2};
        int[] arr = {2, 7, 6, 1, 4, 5};
//        int[] arr = {10, 16, 8, 13, 19, 16, 2, 2, 12, 6, 4, 15, 13, 2};
        System.out.println(new LongestArrayWithSumDivisibleByK().longSubarrWthSumDivByK(arr, 6,3));
    }
}
