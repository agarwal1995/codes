package personal.hashing;

import java.util.HashMap;
import java.util.Map;

public class SubArraysWIthSumK {

    static int findSubArraySum(int Arr[], int N, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int sum = 0;
        for(int x : Arr) {
            sum = sum + x;
            if(sum == k) {
                count++;
            }
            if(map.containsKey(sum-k)) {
                count+=map.get(sum-k);
            }
            map.putIfAbsent(sum, 0);
            map.put(sum, map.get(sum) +1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] Arr = {10 , 2, -2, -20, 10};
        System.out.println(findSubArraySum(Arr, 5, -10));
    }
}
