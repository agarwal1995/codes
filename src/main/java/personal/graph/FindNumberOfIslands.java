package personal.graph;

public class FindNumberOfIslands {

    private int[] xAxis = {-1,-1,-1,0,1,1,1,0};
    private int[] yAxis = {-1,0,1,1,1,0,-1,-1};

    public int numIslands(char[][] grid) {
        int count = 0 ;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i=0;i< grid.length;i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    count++;
                    numIslandsUtil(grid, visited, i, j);
                }
            }
        }
        return count;
    }

    public void numIslandsUtil(char[][] grid, boolean[][] visited, int i, int j) {
        if(visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        for (int k=0;k<8;k++) {
            int nX = i + xAxis[k];
            int nY = j + yAxis[k];

            if(isValid(nX, nY, grid.length, grid[0].length)) {
                if(grid[nX][nY]=='1' && !visited[nX][nY]) {
                    numIslandsUtil(grid, visited, nX, nY);
                }
            }

        }
    }

    private boolean isValid(int i, int j, int m, int n) {
        return i<m && j<n;
    }

    public static void main(String[] args) {

    }
}
