package leetcode.studyplan.datastructure.first;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(!validRow(board, i,j, n)
                        || !validColumn(board, i,j, n)
                        || !validBox(board, i, j, n, 3)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean validRow(char[][] board, int i, int j, int n) {
        char ch = board[i][j];
        for(int k=0;k<n;k++) {
            if(k!=j && ch!='.' && board[i][k] == ch) {
                return false;
            }
        }
        return true;
    }

    private boolean validColumn(char[][] board, int i, int j, int n) {
        char ch = board[i][j];
        for(int k=0;k<n;k++) {
            if(k!=i && ch!='.' && board[k][j] == ch) {
                return false;
            }
        }
        return true;
    }

    private boolean validBox(char[][] board, int i, int j, int n, int c) {
        char ch = board[i][j];
        int a = i/c;
        int b = j/c;
        for(int k=a*c;k<(a+1)*(c);k++) {
            for(int l=b*c;l<(b+1)*(c);l++) {
                if(i!=k && j!=l && ch!='.' && ch==board[k][l]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board =
                {{'.','.','.','.','5','.','.','1','.'},{'.','4','.','3','.','.','.','.','.'},{'.','.','.','.','.','3','.','.','1'},{'8','.','.','.','.','.','.','2','.'},{'.','.','2','.','7','.','.','.','.'},{'.','1','5','.','.','.','.','.','.'},{'.','.','.','.','.','2','.','.','.'},{'.','2','.','9','.','.','.','.','.'},{'.','.','4','.','.','.','.','.','.'}};
        System.out.println(new ValidSudoku().isValidSudoku(board));
    }
}
