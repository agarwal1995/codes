package personal.others;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PrintMatrixZigzag {

    public static void print(int[][] matrix, int n) {
        for (int i=0;i<n;i++) {
            for (int k=0;k<n;k++) {
                System.out.print(matrix[i][k] + "  ");
            }
            System.out.println();
        }
    }

    public static void zigZag(int[][] matrix, int n) {
        int[][] newMatrix = new int[n][n];
        boolean flag = true;
        int count = 1;
        int a = 0;
        int b = 0;
        int i=0;
        int j=0;
        for(int turn =0;turn<n;turn++) {
            for(int d = 1; d<=count; d++) {
                while ((i<n && i>=0)  && (j<n && j>=0)) {
                    if(flag) {
                        System.out.print(matrix[i][j] + "   ");
                        i--;
                        j++;
                    } else {
                        System.out.print(matrix[i][j] + "   ");
                        i++;
                        j--;
                    }
                }
                if(flag) {
                    i = i +1;
                } else {
                    j = j+1;
                }
                flag = !flag;
            }
            count++;
        }


        count = n-1;
        i = n-1;
        j = 1;
        flag = true;
        for(int turn =0;turn<n-1;turn++) {
            for(int d = 1; d<=count; d++) {
                while ((i<n && i>=0)  && (j<n && j>=0)) {
                    if(flag) {
                        System.out.print(matrix[i][j] + "   ");
                        i--;
                        j++;
                    } else {
                        System.out.print(matrix[i][j] + "   ");
                        i++;
                        j--;
                    }
                }
                if(flag) {
                    i = i + 2;
                    j = j - 1;
                } else {
                    j = j + 2;
                    i = i - 1;
                }
                flag = !flag;
            }
            count--;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int[][] matrix = new int[n][n];
        for (int i = 0;i<n; i++) {
            String[] line = br.readLine().trim().split("\\s+");
            for (int k = 0; k<n; k++) {
                int x = Integer.parseInt(line[k]);
                matrix[i][k] = x;
            }
        }
       // print(matrix, n);
        zigZag(matrix, n);
    }
}
