package dp.knapsack.bounded;

public class SubsetSumProblem {
    static Boolean isSubsetSum(int n, int arr[], int sum){
        boolean[][] dp = new boolean[sum+1][n+1];

        for (int i=0;i<=sum;i++) {
            for (int j=0;j<=n;j++) {
                if(i==0) {
                    dp[i][j] = true;
                } else if(j==0) {
                    dp[i][j] = false;
                } else if(arr[j-1]<=i) {
                    dp[i][j] = dp[i][j-1] | dp[i-arr[j-1]][j-1];
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
        int set[] = {3, 34, 4, 12, 5, 2};
        System.out.println(isSubsetSum(6, set, 13));
    }
}
