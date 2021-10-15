package personal.matrix;

import java.util.Arrays;

public class RotateBy90Degrees {

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int x = 0;
        int j = 0;
        for (int t=0;t<n/2;t++) {
            int r = t;
            int c = t;
            for(int i =0;i<n-t*2-1;i++) {
                int temp = matrix[r][c + i];
                matrix[r][c + i] = matrix[n-r-1 - i][c];
                matrix[n-r-1-i][c] = matrix[n-r-1][n-c-1-i];
                matrix[n-r-1][n-c-1-i] = matrix[r+i][n-c-1];
                matrix[r+i][n-c-1]=temp;
            }
        }
    }

    public void print(int[][] matrix) {
        for(int i=0; i<matrix.length; i ++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    public static void main(String[] args) {
//        int[][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        int[][] matrix = {{2,29,20,26,16,28},{12,27,9,25,13,21},{32,33,32,2,28,14},{13,14,32,27,22,26},{33,1,20,7,21,7},{4,24,1,6,32,34}};

        int m = 3;
        int n = 3;

        RotateBy90Degrees rotateBy90Degrees = new RotateBy90Degrees();
        rotateBy90Degrees.print(matrix);
        System.out.println();
        rotateBy90Degrees.rotate(matrix);
        rotateBy90Degrees.print(matrix);


    }
}
