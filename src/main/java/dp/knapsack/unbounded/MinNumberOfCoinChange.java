package dp.knapsack.unbounded;

import java.util.Arrays;

public class MinNumberOfCoinChange {

    public int minCoins(int coins[], int m, int v) {
        int[] dp = new int[v+1];
        for(int i=1;i<=v;i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j=0;j<m;j++) {
                if(coins[j]==i) {
                    dp[i] = 1;
                } else if(coins[j]<i) {
                    if(dp[i-coins[j]]!=0)
                    dp[i] = Math.min(dp[i], dp[i-coins[j]] + 1);
                }
            }
            dp[i] = dp[i]==Integer.MAX_VALUE? 0 : dp[i];
        }
        System.out.println(Arrays.toString(dp));
        return dp[v];
    }

    public static void main(String[] args) {

        int coins[] = {9, 2, 11, 5, 14, 17,8,18};

        System.out.println(new MinNumberOfCoinChange().minCoins(coins, 8, 39));
    }
}
