package dp.knapsack.bounded;

public class Kanpsack01 {

    private static int recursive(int W, int[] val, int[] wt, int i) {
        if(W<=0 || i>=val.length) {
            return 0;
        }
        if(wt[i]<=W) {
            return Math.max(val[i]+recursive(W-wt[i],val,wt,i+1), recursive(W, val, wt, i+1));
        } else {
            return recursive(W,val,wt,i+1);
        }
    }

    private static int dp(int W, int[] val, int[] wt) {
        int[][] dp = new int[W+1][wt.length+1];

        for (int i=1;i<=W;i++) {
            for (int j=1;j<=wt.length;j++) {
                if(wt[j-1]<=i) {
                    dp[i][j] = Math.max(val[j-1] + dp[i-wt[j-1]][j-1], dp[i][j-1]);
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
        return dp[W][wt.length];
    }

    public static void main(String[] args) {
        int[] val = {359, 963, 465, 706, 146, 282, 828, 962, 492};
        int[] wt = {96, 43, 28, 37, 92, 5, 3, 54, 93};
        System.out.println(recursive(383,val,wt,0));
        System.out.println(dp(383,val,wt));
    }

}
