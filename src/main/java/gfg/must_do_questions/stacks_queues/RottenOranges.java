package gfg.must_do_questions.stacks_queues;

import lombok.ToString;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    public static void main(String[] args) {
        RottenOranges rottenOranges = new RottenOranges();
        System.out.println(rottenOranges.orangesRotting(
                new int[][]{
                        {0, 1 , 2},
                        {0, 1 , 2},
                        {2, 1 , 1}
                }

        ));
        System.out.println(rottenOranges.orangesRotting(
                new int[][]{
                        {0, 1 , 2},
                        {0, 1 , 1},
                        {2, 1 , 1}
                }

        ));
    }

    int[] xAxis = {-1,0,1,0};
    int[] yAxis = {0,1,0,-1};

    // Function to find minimum time required to rot all oranges.
    public int orangesRotting(int[][] mat) {
        Queue<Pair> queue = new LinkedList<>();
        for (int i=0;i<mat.length;i++) {
            for (int j=0;j<mat[0].length;j++) {
                if (mat[i][j]==2) {
                    queue.add(new Pair(i, j));
                }
            }
        }

        int cnt = 0;
        while (!queue.isEmpty()) {
            Queue<Pair> secondQueue = new LinkedList<>();
            boolean orangeConverted = false;
            while (!queue.isEmpty()) {
                Pair pair = queue.poll();
                for (int i=0;i<4;i++) {
                    int nx = pair.x + xAxis[i];
                    int ny = pair.y + yAxis[i];
                    if (nx>=0 && ny>=0 && nx<mat.length && ny<mat[0].length && mat[nx][ny]==1) {
                        secondQueue.add(new Pair(nx, ny));
                        mat[nx][ny] = 2;
                        orangeConverted = true;
                    }
                }
            }
            queue = secondQueue;
            cnt = cnt + (orangeConverted?1:0);
        }

        for (int[] ints : mat) {
            for (int j = 0; j < mat[0].length; j++) {
                if (ints[j] == 1) {
                    return -1;
                }
            }
        }

        return cnt;
    }
}

//@ToString
class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
