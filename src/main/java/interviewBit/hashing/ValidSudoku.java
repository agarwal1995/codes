package interviewBit.hashing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidSudoku {

    public int isValidSudoku(final List<String> A) {
        int[][] sudoku = new int[9][9];

        int k = -1;
        for(String s:A) {
            k++;
            for (int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == '.') {
                    sudoku[k][i] = -1;
                } else {
                    sudoku[k][i] = Integer.parseInt(String.valueOf(s.charAt(i)));
                }
            }
        }
//        System.out.println(checkRow(sudoku));
//        System.out.println(checkColumn(sudoku));
//        System.out.println(checkForBox(sudoku));
        if(checkRow(sudoku) && checkColumn(sudoku) && checkForBox(sudoku)) {
            return 1;
        }
        return 0;

    }

    private boolean checkRow(int[][] sudoku) {
        int i = 0;
        int[] num = new int[9];
        while (i<9) {
            num = new int[10];
            for (int j=0;j<9;j++) {
                if(sudoku[i][j]!=-1) {
                    num[sudoku[i][j]]++;
                    if(num[sudoku[i][j]]>1) {
                        return false;
                    }
                }
            }
            i++;
        }
        return true;
    }

    private boolean checkColumn(int[][] sudoku) {
        int i = 0;
        int[] num ;
        while (i<9) {
            num = new int[10];
            for (int j=0;j<9;j++) {
                if(sudoku[j][i]!=-1) {
                    num[sudoku[j][i]]++;
                    if(num[sudoku[j][i]]>1) {
                        return false;
                    }
                }
            }
            i++;
        }
        return true;
    }

    private boolean checkForBox(int[][] sudoku) {
        int k = 0;
        for (k=0;k<9;k++) {
            int[] num = new int[10];
            for(int i=(k/3)*3;i<(k/3)*3+3;i++) {
                int l = (k%3) * 3;
                for(int j=l;j<l+3;j++) {
                    System.out.println("k: " + k +  "  i:" + i + "  j:" + j);
                    if(sudoku[i][j]!=-1) {
                        num[sudoku[i][j]]++;
                        if(num[sudoku[i][j]]>1) {
                            System.out.println("k: " + k +  "  i:" + i + "  j:" + j);
                            System.out.println();
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

        List<String> string = new ArrayList<>();
        string.add("..5.....6");
        string.add("....14...");
        string.add(".........");
        string.add(".....92..");
        string.add("5....2...");
        string.add(".......3.");
        string.add("...54....");
        string.add("3.....42.");
        string.add("...27.6..");
        System.out.println(new ValidSudoku().isValidSudoku(string));

    }


}
