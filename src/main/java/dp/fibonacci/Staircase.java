package dp.fibonacci;

import java.util.Arrays;

public class Staircase {

    /**
     *
     * @param n number of stairs
     * @param m number of stairs that can be jumped at a time max
     * @return number of ways
     */
    private static int dp(int n, int m) {
        int[] dp = new int[n];
        dp[0] =1;
        dp[1] = 2;

        for (int i=2;i<n;i++) {
            dp[i] = 0;
            if(i<m) {
                dp[i] =1;
            }
            for (int j=i-1;j>=i-m && j>=0;j--) {
                dp[i] = dp[i] + dp[j];
            }
        }
        System.out.println(Arrays.toString(dp));
        System.out.println("fs");
        return dp[n-1];
    }

    private static int dpLinear(int n, int m) {
        int[] dp = new int[n];
        dp[0] =1;
        dp[1] = 2;

        int s=0;
        int temp = 3;
        for (int i=2;i<n;i++) {
            dp[i] = 0;
            if(i<m) {
                dp[i] = 1;
            }

            if(i-m>0) {
                temp = temp - dp[s++];
            }
            dp[i] = dp[i] + temp;
            temp = temp + dp[i];
        }
        System.out.println(Arrays.toString(dp));
        System.out.println("fs");
        return dp[n-1];
    }

    public static void main(String[] args) {
        System.out.println(dp(5,3));
//        System.out.println(dpLinear(5,3));
    }
}
