package dp.knapsack.bounded;

public class MinimumSubsetSumDifference {

    private static int dp(int[] array) {
        int sum = 0;
        for (int x: array) {
            sum = sum + x;
        }
        int n = array.length;
        boolean[][] dp = new boolean[sum+1][n+1];

        for (int i=0;i<=sum;i++) {
            for (int j=0;j<=n;j++) {
                if(i==0) {
                    dp[i][j] = true;
                } else if(j==0) {
                    dp[i][j] = false;
                } else if(array[j-1]<=i) {
                    dp[i][j] = dp[i][j-1] | dp[i-array[j-1]][j-1];
                } else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }

        int minDiff = Integer.MAX_VALUE;
        for(int i=1;i<=sum;i++) {
            for (int j=1;j<=n;j++) {
                if(dp[i][j]) {
                    minDiff = Math.min(minDiff, Math.abs((sum-i)-(i)));
                }
            }
        }
        return minDiff;
    }

    public static void main(String[] args) {
        int arr[] = { 3, 1, 4, 2, 2, 1 };
        System.out.println(dp(arr));
    }
}
