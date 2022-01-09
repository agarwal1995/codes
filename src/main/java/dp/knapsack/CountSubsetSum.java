package dp.knapsack;

public class CountSubsetSum {

    private static int dp(int[] arr,int sum) {
        int n = arr.length;
        int[][] dp = new int[sum+1][n+1];

        for (int i=0;i<=sum;i++) {
            for (int j=0;j<=n;j++) {
                if(i==0) {
                    dp[i][j] = 1;
                } else if(j==0) {
                    dp[i][j] = 0;
                } else if(arr[j-1]<=i) {
                    dp[i][j] = dp[i][j-1]+dp[i-arr[j-1]][j-1];
                } else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }

        for (int i=0;i<dp.length;i++) {
            for (int j=0;j<dp[0].length;j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[sum][n];
    }

    public static void main(String[] args) {
        int arr[] = {3, 3, 3, 3};
        System.out.println(dp(arr, 6));
    }
}
