package dp.knapsack.unbounded;

public class CoinChange {

    private static long dp(int coins[],int n,int value) {
        long[][] dp = new long[value+1][n+1];

        for(int i=0;i<=value;i++) {
            for (int j=0;j<=n;j++) {
                if(i==0) {
                    dp[i][j] = 1;
                } else if(j==0) {
                    dp[i][j] = 0;
                } else if(coins[j-1]<=i) {
                    dp[i][j] = dp[i][j-1]+ dp[i-coins[j-1]][j];
                } else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[value][n];
    }
}
