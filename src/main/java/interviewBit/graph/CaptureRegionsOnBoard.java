package interviewBit.graph;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author raag
 */
public class CaptureRegionsOnBoard {

    private int[] nextXCoordinates = {-1,0,1,0};
    private int[] nextYCoordinates = {0 ,1,0,-1};

    public static void main(String[] args) {
        ArrayList<ArrayList<Character>> a = new ArrayList<>();
        a.add(new ArrayList<>(Arrays.asList('X','X','X','X')));
        a.add(new ArrayList<>(Arrays.asList('X','O','O','X')));
        a.add(new ArrayList<>(Arrays.asList('X','X','O','X')));
        a.add(new ArrayList<>(Arrays.asList('X','O','X','X')));
//        a.add(new ArrayList<>(Arrays.asList('X','O','O','O','O','O','O','X')));
//        a.add(new ArrayList<>(Arrays.asList('X','X','O','O','X','O','O','X')));
//        a.add(new ArrayList<>(Arrays.asList('O','X','X','O','X','O','X','X')));

        a.forEach(System.out::println);

        new CaptureRegionsOnBoard().solve(a);

        System.out.println();
        a.forEach(System.out::println);
    }

    public void solve(ArrayList<ArrayList<Character>> a) {
        // replace 'O' with '.
        for (int i=0;i<a.size();i++) {
            for (int j=0;j<a.get(0).size();j++) {
                if (a.get(i).get(j)=='O') {
                    a.get(i).set(j, '.');
                }
            }
        }

        for (int i=0;i<a.size();i++) {
            for (int j=0;j<a.get(0).size();j++) {
                if (i==0 || j==0 || i==a.size()-1 || j==a.get(0).size()-1) {
                    floodFill(a, i, j);
                }
            }
        }


    }

    public void floodFill(ArrayList<ArrayList<Character>> list, int x, int y) {
        if (!isValid(list, x, y)) {
            return;
        }
        if (list.get(x).get(y)!='.') {
            return;
        }

        list.get(x).set(y, 'O');
        floodFill(list, x-1, y);
        floodFill(list, x, y+1);
        floodFill(list, x+1, y);
        floodFill(list, x, y-1);
    }

    private boolean isValid(ArrayList<ArrayList<Character>> list, int x, int y) {
        if (x>=0 && x<list.size() && y>=0 && y<list.get(0).size()) {
            return true;
        }
        return false;
    }

//    public void solve(ArrayList<ArrayList<Character>> a) {
//        int m = a.size();
//        int n = a.get(0).size();
//        boolean[][] visited = new boolean[m][n];
//        for (int i=0;i<m;i++) {
//            for (int j=0;j<n;j++) {
//                if (a.get(i).get(j)=='O' && !visited[i][j])
//                dfs(a, i, j, visited, m, n);
//            }
//        }
//
//    }
//
//    public boolean dfs(ArrayList<ArrayList<Character>> a, int x, int y, boolean[][] visited, int m, int n) {
//        visited[x][y] = true;
//
//
//        for (int i=0;i<4;i++) {
//            int nX = x+nextXCoordinates[i];
//            int nY = y+nextYCoordinates[i];
//
//            if (isValid(m, n, nX, nY) && visited[nX][nY] && a.get(nX).get(nY)=='O') {
//                return true;
//            }
//
//            if (nX==m || nY==n || nX==-1 || nY==-1) {
//                return true;
//            }
//
//            if (isValid(m, n, nX, nY) && !visited[nX][nY]
//                    && a.get(x).get(y)!='X'
//                    && a.get(nX).get(nY)!='X'
//                    && dfs(a, nX, nY, visited, m, n)) {
//                return true;
//            }
//        }
//        a.get(x).set(y, 'X');
//        return false;
//    }
//
//    private boolean isValid(int m, int n, int x, int y) {
//        return x>=0 && y>=0 && x<m && y<n;
//    }
}
