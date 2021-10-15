package personal.matrix;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BooleanMatrix {

    void booleanMatrix(int matrix[][]) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(matrix[i][j] == 1) {
                    matrix[i][0] = 2;
                    matrix[0][j] = 2;
                }
            }
        }

        for (int i=0;i<m;i++) {
            if(matrix[i][0] == 2) {
                for(int j=1;j<n;j++) {
                    matrix[i][j] = matrix[i][j] == 2? 2:1;
                }
            }
        }

        for (int j=0;j<n;j++) {
            if(matrix[0][j] == 2) {
                for(int i=1;i<m;i++) {
                    matrix[i][j] = matrix[i][j] == 2? 2:1;
                }
            }
        }

        for (int i=0;i<m;i++) {
            matrix[i][0] = matrix[i][0] == 2 ? 1 : matrix[i][0];
        }

        for (int j=0;j<n;j++) {
            matrix[0][j] = matrix[0][j] == 2 ? 1 : matrix[0][j];
        }
    }

    void print(int[][] matrix, int m, int n) {
        for(int i=0;i<m;i++) {
            System.out.println();
            for(int j=0;j<n;j++) {
                System.out.print(matrix[i][j] +" ");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().trim().split("\\s+");
        int m = Integer.parseInt(line1[0]);
        int n = Integer.parseInt(line1[1]);

        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            String[] line = br.readLine().trim().split("\\s+");
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(line[j]);
            }
        }

        BooleanMatrix booleanMatrix = new BooleanMatrix();
        booleanMatrix.booleanMatrix(matrix);
        booleanMatrix.print(matrix, m, n);
    }
}
