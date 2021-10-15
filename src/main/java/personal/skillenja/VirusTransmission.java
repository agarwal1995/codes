package personal.skillenja;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class VirusTransmission {

    static int[][] moves = {{-1,0},{0,-1},{1,0},{0,1}};


    private static class Temp {
        int x,y,cost;
        Temp(int x, int y, int cost) {
            this.x = x; this.y = y; this.cost = cost;
        }
    }

    public static void virusTransmissionUtil(PriorityQueue<Temp> pq, char[][] array, int m, int n) {
        int totalCost = 0;
        int xi = 0, yi = 0;
        while (!pq.isEmpty()) {
            Temp temp = pq.poll();
            totalCost = Math.max(totalCost, temp.cost);

            for(int i=0;i<4;i++) {
                xi = moves[i][0] + temp.x;
                yi = moves[i][1] + temp.y;

                if(xi>=0 && yi>=0 && xi<m && yi<n && (array[xi][yi] != '0' && array[xi][yi] != '_')) {
                    if(array[xi][yi] == '1') {
                        array[xi][yi] = '0';
                        pq.add(new Temp(xi, yi, temp.cost + 1));
                    }
                    if(array[xi][yi] == '2') {
                        array[xi][yi] = '0';
                        pq.add(new Temp(xi, yi, temp.cost + 2));
                    }
                }
            }
            array[temp.x][temp.y] ='0';
        }

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(array[i][j]=='1' || array[i][j]=='2') {
                    System.out.println("-1");
                    return;
                }
            }
        }
        System.out.println(totalCost);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t>0) {
            PriorityQueue<Temp> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));

            String[] line = br.readLine().trim().split("\\s+");
            int m = Integer.parseInt(line[0]);
            int n = Integer.parseInt(line[1]);
            char[][] array = new char[m][n];
            for(int i=0;i<m;i++) {
                String str = br.readLine().trim();
                for(int j=0;j<n;j++) {
                    array[i][j] = str.charAt(j);
                    // already infected
                    if(str.charAt(j) == '0') {
                        pq.add(new Temp(i, j, 0));
                    }
                }
            }
            virusTransmissionUtil(pq, array, m, n);

            t--;
        }
    }

}
