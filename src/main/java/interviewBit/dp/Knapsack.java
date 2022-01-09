package interviewBit.dp;

import java.util.ArrayList;

public class Knapsack {

    public int solve(ArrayList<Integer> val, ArrayList<Integer> wt, int W) {
        int[][] dp = new int[W+1][wt.size()+1];

        for (int i=1;i<=W;i++) {
            for (int j=1;j<=wt.size();j++) {
                if(wt.get(j-1)<=i) {
                    dp[i][j] = Math.max(val.get(j-1) + dp[i-wt.get(j-1)][j-1], dp[i][j-1]);
                } else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[W][wt.size()-1];
    }
}
