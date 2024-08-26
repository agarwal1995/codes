package interviewBit.graph;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * Given a binary matrix A of size N x M.
 * Cells which contain 1 are called filled cell and cell that contain 0 are called empty cell.
 * Two cells are said to be connected if they are adjacent to each other horizontally, vertically, or diagonally.
 * If one or more filled cells are also connected, they form a region. Find the length of the largest region.
 *
 * @author raag
 */
public class RegionInBinaryMatrix {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
//        list.add(new ArrayList<>(Arrays.asList(0,0,1,0,0,0,0,0)));
//        list.add(new ArrayList<>(Arrays.asList(1,1,1,1,1,1,1,0)));
        list.add(new ArrayList<>(Arrays.asList(1,0)));
        list.add(new ArrayList<>(Arrays.asList(1,1)));
        list.add(new ArrayList<>(Arrays.asList(0,0)));
        list.add(new ArrayList<>(Arrays.asList(0,0)));
        list.add(new ArrayList<>(Arrays.asList(0,0)));
        list.add(new ArrayList<>(Arrays.asList(1,0)));
        list.add(new ArrayList<>(Arrays.asList(0,1)));
        int m = new RegionInBinaryMatrix().solve(list);
        System.out.println(m);
    }

    static int max = 0;
    /**
     * max stores the max region
     * xAxis and yAxis contains the coordinates to move from a point to all
     * directions
     */
    int[] xAxis = {-1,-1,-1,0,1,1,1,0};
    int[] yAxis = {-1,0,1,1,1,0,-1,-1};

    /**
     * iterate over the whole list if point is not visited
     * every time it starts with length of region =0
     * @param A input integer list
     * @return max region
     */
    public int solve(ArrayList<ArrayList<Integer>> A) {
        int m = A.size();
        int n = A.get(0).size();
        boolean[][] visited = new boolean[m][n];

        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if (!visited[i][j]) {
                    dfs(A, visited, m, n, i, j, 0);
                }
            }
        }
        return max;
    }

    /**
     *
     * @param list adjacency list
     * @param visited boolean array to keep track whether the point is visited or not
     * @param m adjacency list row size
     * @param n adjacency list column size
     * @param i current i index
     * @param j current j index
     * @param sum current max region
     * @return
     */
    public int dfs(ArrayList<ArrayList<Integer>> list, boolean[][] visited, int m, int n, int i, int j, int sum) {
        if (!isValid(m, n, i, j)) {
            return sum;
        }

        if (visited[i][j]) {
            return sum;
        }
        if (list.get(i).get(j)==0) {
            return sum;
        }
        visited[i][j] = true;
        sum = sum+1;
        max = Math.max(sum, max);

        for (int k=0;k<8;k++) {
            int nI = xAxis[k] + i;
            int nJ = yAxis[k] + j;
            sum = dfs(list, visited, m, n, nI, nJ, sum);
        }
        return sum;
    }

    public boolean isValid(int m, int n, int i, int j) {
        return i < m && j < n && i >= 0 && j >= 0;
    }
}
