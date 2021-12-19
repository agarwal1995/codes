package discussions.pharmeasy;

public class FindPath {

    static int[] xAxis = {0,-1,0,1};
    static int[] yAxis = {-1,0,1,0};

    private static boolean isPathExist(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        return util(grid, 0, 0, m, n, visited);
    }

    private static boolean util(int[][] grid, int i, int j, int m, int n, boolean[][] visited) {
        if(i == m-1 && j == n-1) {
            return true;
        }
        visited[i][j] = true;
        for(int k=0;k<4;k++) {
            int nR = i + xAxis[k];
            int nC = j + yAxis[k];
            if(valid(nR, nC, m, n) && !visited[nR][nC] && grid[nR][nC]==1) {
                return util(grid, nR, nC, m, n, visited);
            }
        }
        return false;
    }

    private static boolean valid(int i, int j, int m, int n) {
        return i>=0 && i<m && j>=0 && j<n;
    }

    public static void main(String[] args) {
        int[][] grid = new int[4][5];
        grid[0] = new int[]{1, 0, 0, 0, 0};
        grid[1] = new int[]{1, 1, 1, 0, 0};
        grid[2] = new int[]{0, 0, 1, 1, 1};
        grid[3] = new int[]{0, 0, 0, 0, 1};
        System.out.println(isPathExist(grid));
    }
}
