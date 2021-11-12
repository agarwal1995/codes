package personal.matrix;

import java.util.ArrayList;
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


    public void rotate(ArrayList<ArrayList<Integer>> a) {
        int n = a.size();
        for (ArrayList<Integer> list : a) {
            System.out.println(list);
        }
        int t = 0;
        for (t=0; t<n/2;t++) {
            for (int i = 0; i < n - 2*t - 1; i++) {
                int temp = a.get(t).get(t + i);
//                a.get(t).set(t+i, a.get(n-t-1-i).get(t));
//                a.get(n-t-1-i).set(t, a.get(n-t-1).get(n-t-1-i));
//                a.get(n-t-1).set(n-t-1-i, a.get(t+i).get(n-t-1));
//                a.get(t+i).set(n-t-1, temp);

//                a.get(t).set(t+i, a.get(t+i).get(n-t-1));
//                a.get(t+i).set(n-t-1, a.get(n-t-1).get(n-t-1-i));
//                a.get(n-t-1).set(n-t-1-i, a.get(n-t-1-i).get(t));
//                a.get(n-t-1-i).set(t, temp);
                System.out.println(a.get(t).get(t+i));
                System.out.println(a.get(n-t-1-i).get(t));
                System.out.println(a.get(n-t-1).get(n-t-1-i));
                System.out.println(a.get(t+i).get(n-t-1));
            }
        }
        System.out.println();
        for (ArrayList<Integer> list : a) {
            System.out.println(list);
        }
    }


    public void print(int[][] matrix) {
        for(int i=0; i<matrix.length; i ++) {
            System.out.println(Arrays.toString(matrix[i]));
        }

    }

    public static void main(String[] args) {
//        int[][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
//        int[][] matrix = {{2,29,20,26,16,28},{12,27,9,25,13,21},{32,33,32,2,28,14},{13,14,32,27,22,26},{33,1,20,7,21,7},{4,24,1,6,32,34}};
//
//        int m = 3;
//        int n = 3;
//
//        RotateBy90Degrees rotateBy90Degrees = new RotateBy90Degrees();
//        rotateBy90Degrees.print(matrix);
//        System.out.println();
//        rotateBy90Degrees.rotate(matrix);
//        rotateBy90Degrees.print(matrix);

        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        ArrayList<Integer> row1 = new ArrayList<>();
        row1.add(1);
        row1.add(2);
        row1.add(3);
        row1.add(10);
        ArrayList<Integer> row2 = new ArrayList<>();
        row2.add(4);
        row2.add(5);
        row2.add(6);
        row2.add(11);
        ArrayList<Integer> row3 = new ArrayList<>();
        row3.add(7);
        row3.add(8);
        row3.add(9);
        row3.add(12);
        ArrayList<Integer> row4 = new ArrayList<>();
        row4.add(13);
        row4.add(14);
        row4.add(15);
        row4.add(16);
        lists.add(row1);
        lists.add(row2);
        lists.add(row3);
        lists.add(row4);
        new RotateBy90Degrees().rotate(lists);


    }
}
