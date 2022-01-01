package personal.dp;

public class LongestPathInAMatrixWithGivenConstraints {

    static int[] xAxis = {0,1,0,-1};
    static int[] yAxis = {1,0,-1,0};

    public static int longestPath(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] sol = new int[m][n];

        sol[0][0] = 1;
        for(int i=1;i<m;i++) {
            sol[i][0] = Math.abs(sol[i-1][0]-sol[i][0]) == 1 ? sol[i-1][0]+1 : 1;
        }

        for(int j=1;j<n;j++) {
            sol[0][j] = Math.abs(sol[0][j-1]-sol[0][j]) == 1 ? sol[0][j-1]+1 : 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int x = mat[i][j];
                int upper = mat[i-1][j];
                int lower = mat[i][j-1];
                if(Math.abs(upper-x) == 1 && Math.abs(lower-x)==1) {
                    sol[i][j] = sol[i-1][j] + sol[i][j-1] + 1;
                } else {
                    sol[i][j] = Math.max(Math.abs(mat[i][j-1]-x) == 1 ? sol[i][j-1]: 0, Math.abs(mat[i-1][j]-x) == 1 ? sol[i-1][j] : 0) + 1;
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i=0;i<m;i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, sol[i][j]);
            }
        }
        return max;
    }

    private static boolean isValid(int x, int y, int m, int n) {
        return x>=0 && y>=0 && x<m && y<n;
    }

    public static void main(String[] args) {
        int[][] mat =  {{1,2,9}, {5,3,8}, {4,6,7}};
        System.out.println(longestPath(mat));
    }

}
