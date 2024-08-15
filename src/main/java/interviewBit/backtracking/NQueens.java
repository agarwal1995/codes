package interviewBit.backtracking;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author raag
 */
public class NQueens {

    public static void main(String[] args) {
        new NQueens().solveNQueens(8);
    }

    private ArrayList<ArrayList<String>> result = new ArrayList<>();

    public ArrayList<ArrayList<String>> solveNQueens(int a) {
        int[][] matrix = new int[a][a];
        rec(a, 0, matrix);
        return result;
    }

    private void rec(int n, int currIndexX, int[][] matrix) {
        if (currIndexX==n) {
            ArrayList<String> list = new ArrayList<>();
            for (int i=0;i<n;i++) {
                StringBuilder sbr = new StringBuilder();
                for (int j=0;j<n;j++) {
                    sbr.append(matrix[i][j]==1?"Q":".");
                }
//                if(i!=n-1) {
//                    sbr.append(",");
//                }
                list.add(sbr.toString());
            }
            result.add(list);
            return;
        }

        for (int j=0;j<n;j++) {
            if (checkValid(matrix, currIndexX, j)) {
                matrix[currIndexX][j]=1;
                rec(n, currIndexX+1, matrix);
                matrix[currIndexX][j]=0;
            }
        }
    }

    private boolean checkValid(int[][] matrix, int x, int y) {
        return checkValidVertical(matrix, x, y)
                && checkValidHorizontal(matrix, x, y)
                && checkValidDiagonal(matrix, x, y);
    }

    private boolean checkValidVertical(int[][] matrix, int x, int y) {
        for (int i=x+1;i<matrix.length;i++) {
            if (matrix[i][y]==1) {
                return false;
            }
        }
        for (int i=x-1;i>=0;i--) {
            if (matrix[i][y]==1) {
                return false;
            }
        }
        return true;
    }

    private boolean checkValidHorizontal(int[][] matrix, int x, int y) {
        for (int j=y+1;j<matrix.length;j++) {
            if (matrix[x][j]==1) {
                return false;
            }
        }
        for (int j=y-1;j>=0;j--) {
            if (matrix[x][j]==1) {
                return false;
            }
        }
        return true;
    }

    private boolean checkValidDiagonal(int[][] matrix, int x, int y) {
        int n = matrix.length;
        int i=x+1,j=y+1;
        while (i<n && j<n) {
            if (matrix[i][j]==1) {
                return false;
            }
            i++;
            j++;
        }

        i=x+1;j=y-1;
        while (i<n && j>=0) {
            if (matrix[i][j]==1) {
                return false;
            }
            i++;j--;
        }

        i=x-1;j=y-1;
        while (i>=0 && j>=0) {
            if (matrix[i][j]==1) {
                return false;
            }
            i--;j--;
        }

        i=x-1;j=y+1;
        while (i>=0 && j<n) {
            if (matrix[i][j]==1) {
                return false;
            }
            i--;j++;
        }

        return true;
    }
}
