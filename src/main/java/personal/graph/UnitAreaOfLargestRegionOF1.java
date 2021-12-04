package personal.graph;

public class UnitAreaOfLargestRegionOF1 {

    class MaxValue {
        public int x;
    }

    private int[] xMoves = {0,1,1,1,0,-1,-1,-1};
    private int[] yMoves = {1,1,0,-1,-1,-1,0,1};

    public int findMaxArea(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        MaxValue maxValue = new MaxValue();
        boolean[][] visited = new boolean[m][n];
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if(!visited[i][j]) {
                    findMaxAreaUtil(grid, m, n, i, j, maxValue, visited, new MaxValue());
                }
            }
        }
        return maxValue.x+1;
    }

    public void findMaxAreaUtil(int[][] grid, int m, int n, int i, int j, MaxValue maxValue, boolean[][] visited, MaxValue current) {
        if(i>=m || j>=n || i<0 || j<0) {
            return;
        }
        if(grid[i][j] == 0 || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        maxValue.x = Math.max(maxValue.x, current.x);
        current.x = current.x + 1;
        for(int k=0;k<8;k++) {
            int xMove = i + xMoves[k];
            int yMove = j + yMoves[k];
            findMaxAreaUtil(grid, m, n, xMove, yMove, maxValue, visited, current);
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{1,1,1,0},{0,0,1,0},{0,0,0,1}};
//        int[][] grid = {{0,1},{0,1},{1,0},{1,1},{1,0},{1,1},{0,0}};
        System.out.println(new UnitAreaOfLargestRegionOF1().findMaxArea(grid));
    }
}
