package interviewBit.backtracking;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author raag
 */
public class Sudoku {

    public static void main(String[] args) {
        ArrayList<ArrayList<Character>> arrayLists = new ArrayList<>();
        arrayLists.add(new ArrayList<>(Arrays.asList('5','3','.','.','7','.','.','.','.')));
        arrayLists.add(new ArrayList<>(Arrays.asList('6','.','.','1','9','5','.','.','.')));
        arrayLists.add(new ArrayList<>(Arrays.asList('.','9','8','.','.','.','.','6','.')));
        arrayLists.add(new ArrayList<>(Arrays.asList('8','.','.','.','6','.','.','.','3')));
        arrayLists.add(new ArrayList<>(Arrays.asList('4','.','.','8','.','3','.','.','1')));
        arrayLists.add(new ArrayList<>(Arrays.asList('7','.','.','.','2','.','.','.','6')));
        arrayLists.add(new ArrayList<>(Arrays.asList('.','6','.','.','.','.','2','8','.')));
        arrayLists.add(new ArrayList<>(Arrays.asList('.','.','.','4','1','9','.','.','5')));
        arrayLists.add(new ArrayList<>(Arrays.asList('.','.','.','.','8','.','.','7','9')));

        ArrayList<ArrayList<Character>> arrayLists2 = new ArrayList<>();
        arrayLists2.add(new ArrayList<>(Arrays.asList('1','.','.','.')));
        arrayLists2.add(new ArrayList<>(Arrays.asList('.','.','.','.')));
        arrayLists2.add(new ArrayList<>(Arrays.asList('.','.','4','.')));
        arrayLists2.add(new ArrayList<>(Arrays.asList('.','.','.','.')));

        new Sudoku().solveSudoku(arrayLists);
    }

    public void solveSudoku(ArrayList<ArrayList<Character>> a) {
        int[][] matrix = new int[a.size()][a.size()];
        for (int i=0;i<a.size();i++) {
            for (int j=0;j<a.size();j++) {
                matrix[i][j] = a.get(i).get(j) == '.'?0: a.get(i).get(j)-48;
            }
        }
        rec(matrix, 0, 0);
        for (int i=0;i<9;i++) {
            for (int j=0;j<9;j++) {
                a.get(i).set(j, (char) (matrix[i][j] + '0'));
            }
        }
    }

    private boolean rec(int[][] matrix, int x, int y) {
        if(x==9) {
            for (int[] ints : matrix) {
                System.out.println(Arrays.toString(ints));
            }
            return true;
        }
        if (y==9) {
            return rec(matrix, x+1, 0);
        }
        if (matrix[x][y]!=0) {
            return rec(matrix, x, y+1);
        }

        for (int i=1;i<=9;i++) {
            if(checkValid(matrix, x, y, i)) {
                matrix[x][y]=i;
                if (rec(matrix, x, y+1)) {
                    return true;
                } else
                    matrix[x][y]=0;
            }
        }
        return false;
    }

    private boolean checkValid(int[][] matrix, int x, int y, int num) {
        return checkValidRow(matrix, x, y, num)
                && checkValidColumn(matrix, x, y, num)
                && checkValidBox(matrix, x, y, num);
    }

    private boolean checkValidColumn(int[][] matrix, int x, int y, int num) {
        for (int i=x+1;i<matrix.length;i++) {
            if (matrix[i][y]==num) {
                return false;
            }
        }
        for (int i=x-1;i>=0;i--) {
            if (matrix[i][y]==num) {
                return false;
            }
        }
        return true;
    }

    private boolean checkValidRow(int[][] matrix, int x, int y, int num) {
        for (int i=y+1;i<matrix.length;i++) {
            if (matrix[x][i]==num) {
                return false;
            }
        }
        for (int i=y-1;i>=0;i--) {
            if (matrix[x][i]==num) {
                return false;
            }
        }
        return true;
    }

    private boolean checkValidBox(int[][] matrix, int x, int y, int num) {
        int n = (int)Math.sqrt(matrix.length);
        int xB = (x/n) * n;
        int yB = (y/n) * n;
        for (int i=xB;i<xB+n;i++) {
            for (int j=yB;j<yB+n;j++) {
                if (i!=x && j!=y && matrix[i][j]==num) {
                    return false;
                }
            }
        }
        return true;
    }
}
