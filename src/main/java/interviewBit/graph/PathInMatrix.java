package interviewBit.graph;

import interviewBit.graph.helpers.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author raag
 */
public class PathInMatrix {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        A.add(new ArrayList<>(Arrays.asList(1,0)));
        A.add(new ArrayList<>(Arrays.asList(0,2)));

        System.out.println(new PathInMatrix().checkPath(A));
    }

    public int checkPath(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        boolean[][] visited = new boolean[n][n];

        Pair pair = null;

        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                if (A.get(i).get(j)==1) {
                    pair = new Pair(i, j);
                }
            }
        }

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(pair);

        int[] xAxis = {0, -1, 0, 1};
        int[] yAxis = {-1, 0, 1, 0};
        while (!queue.isEmpty()) {
            Pair pair1 = queue.poll();
            visited[pair1.a][pair1.b] = true;

            if (A.get(pair1.a).get(pair1.b)==2) {
                return 1;
            }

            for (int k=0;k<4;k++) {
                int x = pair1.a+xAxis[k];
                int y = pair1.b+yAxis[k];
                if (isValid(n, x, y) && !visited[x][y] && A.get(x).get(y)!=0) {
                    if (A.get(x).get(y)==2) {
                        return 1;
                    }
                    queue.offer(new Pair(x, y));
                    A.get(x).set(y, 0);
                }
            }
        }
        return 0;
    }

    private boolean isValid(int n, int x, int y) {
        return x>=0 && y>=0 && x<n && y<n;
    }
}

