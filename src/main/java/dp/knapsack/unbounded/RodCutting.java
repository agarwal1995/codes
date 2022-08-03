package dp.knapsack.unbounded;

public class RodCutting {

    private static int dp(int[] price, int n) {
        int[] dp = new int[n+1];
        for(int i=1;i<=n;i++) {
            for (int j=0;j<i;j++) {
                dp[i] = Math.max(dp[i], dp[i-1-j] + price[j]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int price[] = {1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println(dp(price, 8));

    }
}
