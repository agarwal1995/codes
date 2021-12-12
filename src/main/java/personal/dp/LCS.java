package personal.dp;

public class LCS {

   public void dpSolution(String first, String second) {
       int m = first.length();
       int n = second.length();
       int[][] dp = new int[m][n];

       for(int i=0;i<m;i++) {
           if(first.charAt(i) == second.charAt(0)) {
               dp[i][0] = 1;
           }
       }

       for(int j=0;j<n;j++) {
           if(second.charAt(j) == first.charAt(0)) {
               dp[0][j] = 1;
           }
       }


       for (int i=1;i<m;i++) {
           for (int j=1;j<n;j++) {
               if(first.charAt(i) == second.charAt(j)) {
                   dp[i][j] = dp[i-1][j-1] + 1;
               } else {
                   dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
               }
           }
       }
       System.out.println(dp[m-1][n-1]);
       printLCS(dp, m, n, first, second);
   }


   private void printLCS(int[][] dp, int m, int n, String first, String second) {
       StringBuilder sbr = new StringBuilder();

       int i = m-1;
       int j = n-1;

       while (i>=0 && j>=0) {
           if(first.charAt(i) == second.charAt(j)) {
               sbr.append(first.charAt(i));
               i--;
               j--;
               continue;
           }
           if(i==0 || j==0) {
               break;
           }
           if (dp[i-1][j] > dp[i][j-1]) {
               i--;
           } else {
               j--;
           }
       }
       System.out.println(sbr.reverse());
   }

    public static void main(String[] args) {
       new LCS().dpSolution("AGGTAB","GXTXAYB");
    }
}
