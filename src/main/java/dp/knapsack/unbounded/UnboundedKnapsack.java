package dp.knapsack.unbounded;

public class UnboundedKnapsack {

    private static int recursive(int[] val, int[] wt, int W, int n) {
        if(W==0 || n==0) {
            return 0;
        }
        if(W>=wt[n-1]) {
            return Math.max(recursive(val, wt, W-wt[n-1], n) + val[n-1], recursive(val, wt, W, n-1));
        }
        return recursive(val, wt, W, n-1);
    }

    private static int dp(int[] val, int[] wt, int W,int n) {
        int dp[] = new int[W + 1];

        for (int i = 1; i <= W; i++) {
            for (int j = 0; j < n; j++) {
                if (wt[j] <= i) {
                    dp[i] = Math.max(dp[i - wt[j]] + val[j], dp[i]);
                }
            }
        }
        return dp[W];
    }

    public static void main(String[] args) {
        int val[] = {10, 40, 50, 70};
        int wt[]  = {1, 3, 4, 5};

        System.out.println(recursive(val, wt, 8, 4));
        System.out.println(dp(val, wt, 8, 4));
    }

}
