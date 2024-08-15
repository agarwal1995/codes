package interviewBit.queue;

import java.util.*;

/**
 * @author raag
 */
public class BfsService {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        A.add(new ArrayList<>(Arrays.asList(0,0)));
        A.add(new ArrayList<>(Arrays.asList(1,0)));

        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        B.add(new ArrayList<>(Arrays.asList(1,1)));
        B.add(new ArrayList<>(Arrays.asList(2,1)));
        B.add(new ArrayList<>(Arrays.asList(1,2)));


        System.out.println(new BfsService().nearestHotel(A, B));
    }

    public ArrayList<Integer> nearestHotel(ArrayList<ArrayList<Integer>> A, ArrayList<ArrayList<Integer>> B) {
        Queue<Pair2> pairs = new LinkedList<>();

        int[] xMove = {0, 1, 0, -1};
        int[] yMove = {1, 0, -1, 0};

        ArrayList<Integer> result = new ArrayList<>();
        Map<Pair2, Integer> minDistanceMap = new HashMap<>();
        int n = A.size();
        int m = A.get(0).size();

        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                if (A.get(i).get(j)==1)
                pairs.add(new Pair2(i, j, 0));
            }
        }

        int[][] dist = new int[n][m];
        while (!pairs.isEmpty()) {
            int size = pairs.size();
            for (int i=0;i<size;i++) {
                Pair2 pair = pairs.poll();
                for (int mo=0;mo<4;mo++) {
                    int nx = pair.x + xMove[mo];
                    int ny = pair.y + yMove[mo];
                    if (isValidCoordinate(n, m, nx, ny, dist) && A.get(nx).get(ny)==0) {
                        dist[nx][ny] = dist[pair.x][pair.y]+1;
                        pairs.add(new Pair2(nx, ny, 0));
                    }
                }
            }
        }

//        for (int[] d : dist) {
//            System.out.println(Arrays.toString(d));
//        }
        for (int x=0;x<B.size();x++) {
            result.add(dist[B.get(x).get(0)-1][B.get(x).get(1)-1]);
        }

//        for(int i=0;i<n;i++) {
//            for (int j=0;j<m;j++){
//                int minDistance = Integer.MAX_VALUE;
//                boolean[][] visited = new boolean[n][m];
//                pairs.clear();
//                pairs.add(new Pair2(i, j));
//                while (!pairs.isEmpty()) {
//                    Pair2 pair = pairs.poll();
//                    if (A.get(pair.x).get(pair.y)==1) {
//                        minDistanceMap.putIfAbsent(new Pair2(i,j), pair.dist);
//                        break;
//                    }
//                    for (int mo=0;mo<4;mo++) {
//                        int nx = pair.x + xMove[mo];
//                        int ny = pair.y + yMove[mo];
//                        if (isValidCoordinate(n, m, nx, ny, visited)) {
//                            visited[nx][ny] = true;
//                            pairs.add(new Pair2(nx, ny, pair.dist+1));
//                        }
//                    }
//                }
//            }
//        }
//
//        for (int x=0;x<B.size();x++) {
//            result.add(minDistanceMap.get(new Pair2(B.get(x).get(0)-1, B.get(x).get(1)-1)));
//        }
//
//        System.out.println(result);


//        for (int k=0;k<B.size();k++) {
//            int minDistance = Integer.MAX_VALUE;
//            boolean[][] visited = new boolean[n][m];
//            int i = B.get(k).get(0)-1;
//            int j = B.get(k).get(1)-1;
//            pairs.clear();
//            pairs.add(new Pair2(i, j));
//            while (!pairs.isEmpty()) {
//                Pair2 pair = pairs.poll();
//                if (A.get(pair.x).get(pair.y)==1) {
//                    result.add(pair.dist);
//                    break;
//                }
//                for (int mo=0;mo<4;mo++) {
//                    int nx = pair.x + xMove[mo];
//                    int ny = pair.y + yMove[mo];
//                    if (isValidCoordinate(n, m, nx, ny, visited)) {
//                        visited[nx][ny] = true;
//                        pairs.add(new Pair2(nx, ny, pair.dist+1));
//                    }
//                }
//            }
//        }
        return result;
    }



    private boolean isValidCoordinate(int n, int m, int i, int j, int[][] visited) {
        return i<n && j<m && i>=0 && j>=0 && visited[i][j]==0;
    }
}


class Pair2 {
    int x;
    int y;
    int dist;

    Pair2(int x, int y) {
        this.x = x;
        this.y=y;
        dist = 0;
    }
    Pair2(int x, int y, int dist) {
        this.x = x;
        this.y=y;
        this.dist = dist;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Pair2) {
            Pair2 toPair = (Pair2) obj;
            return this.x == toPair.x && this.y == toPair.y;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Pair2{" +
                "x=" + x +
                ", y=" + y +
                ", dist=" + dist +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}