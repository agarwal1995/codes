package dp.knapsack.bounded;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

public class TargetSum {

    private static int recursive(int[] arr, int target, int n) {
        return recursiveUtil(arr, target, 0, n);
    }

    private static int recursiveUtil(int[] arr, int target, int sum, int n) {
        if (n==0) {
            if(target==sum) {
                System.out.println("Return 1");
                return 1;
            }
            System.out.println("Return 0");
            return 0;
        }
        System.out.println(sum + "  " + n);
        return recursiveUtil(arr, target, +arr[n-1]+sum, n-1) + recursiveUtil(arr, target, -arr[n-1]+sum, n-1);
    }

    private static int dp(int[] arr, int target, int n) {
        return dpUtil(arr, target, 0, n, new HashMap<>(), 0);
    }

    private static int dpUtil(int[] arr, int target, int i, int n, Map<Pair, Integer> map, int sum) {
        if (n==0) {
            if(target==sum) {
                return 1;
            }
            return 0;
        }
        if(map.containsKey(new Pair(n, sum))) {
            System.out.println(i+ "   " +sum);
            return map.get(new Pair(n, sum));
        }
        int x = dpUtil(arr, target,i+1,n-1, map, +arr[n-1]+sum) + dpUtil(arr, target, i+1, n-1, map, -arr[n-1]+sum);
        map.put(new Pair(n, sum), x);
        return x;
    }

    public static void main(String[] args) {
        int A[] = {1, 1, 1,1,1};
        System.out.println(dp(A, 3, 5));

    }
}

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
class Pair {
    int a;
    int b;


}