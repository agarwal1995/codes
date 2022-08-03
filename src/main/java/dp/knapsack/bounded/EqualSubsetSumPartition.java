package dp.knapsack.bounded;

public class EqualSubsetSumPartition {

    private static boolean dp(int n, int arr[]) {
        int sum = 0;
        for(int x : arr) {
            sum +=x;
        }
        if(sum%2!=0) {
            return false;
        }
        return isSubsetSum(n, arr, sum/2);
    }

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
        return dp[sum][n];
    }

    public static void main(String[] args) {
        int arr[] = {1, 5, 11, 5,4};
        System.out.println(dp(5, arr));
    }
}
