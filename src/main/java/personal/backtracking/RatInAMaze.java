package personal.backtracking;

import java.util.ArrayList;
import java.util.Collections;

public class RatInAMaze {

    public static ArrayList<String> findPath(int[][] m, int n) {
        boolean[][] visited = new boolean[n][n];
        ArrayList<String> list = new ArrayList<>();
        findPathUtil(m, list, n, 0,0,new StringBuilder(), visited);
        Collections.sort(list);
        return list;
    }

    static void findPathUtil(int[][] m, ArrayList<String> list, int n, int i, int j, StringBuilder path, boolean[][] visited) {
        if(i<0 || j<0 || i>=n || j>=n || visited[i][j] || m[i][j]!=1) {
            return;
        }
        if(i==n-1 && j==n-1) {
            list.add(new String(path));
            return;
        }

        visited[i][j] = true;

        path.append("U");
        findPathUtil(m, list, n, i-1, j, path, visited);
        path.deleteCharAt(path.length()-1);

        path.append("D");
        findPathUtil(m, list, n, i+1, j, path, visited);
        path.deleteCharAt(path.length()-1);

        path.append("L");
        findPathUtil(m, list, n, i, j-1, path, visited);
        path.deleteCharAt(path.length()-1);

        path.append("R");
        findPathUtil(m, list, n, i, j+1, path, visited);
        path.deleteCharAt(path.length()-1);

        visited[i][j] = false;
    }

    public static void main(String[] args) {
        int n = 4;
        int m[][] = {{1, 0, 0, 0},
            {1, 1, 0, 1},
            {1, 1, 0, 0},
            {0, 1, 1, 1}};
        System.out.println(findPath(m, n));
    }
}
