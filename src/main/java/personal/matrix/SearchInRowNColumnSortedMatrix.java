package personal.matrix;

public class SearchInRowNColumnSortedMatrix {

    public static int matSearch(int mat[][], int N, int M, int X) {
        int i=0;
        int j = M-1;

        int solRow = -1;
        int solCol = -1;
        while (i>=0 && i<N && j>=0 && j<M) {
            if(mat[i][j]==X) {
                solRow = i;
                solCol = j;
                break;
            }

            if(mat[i][j] > X) {
                j--;
                continue;
            }
            if (mat[i][j]<X) {
                i++;
            }
        }
        if (solCol!=-1) {
            return 1;
        }
        return 0;
    }



    public static void main(String[] args) throws Exception {
       int  mat[][] = { {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50}};
        System.out.println(matSearch(mat, 4,4,23));
    }
}
