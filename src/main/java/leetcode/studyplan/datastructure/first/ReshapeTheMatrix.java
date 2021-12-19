package leetcode.studyplan.datastructure.first;

public class ReshapeTheMatrix {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int[][] reshape = new int[r][c];
        int a=0,b=0;
        int m = mat.length;
        int n = mat[0].length;
        if(m * n != r * c) {
            return mat;
        }
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                reshape[a][b] = mat[i][j];
                if(b<c-1) {
                    b++;
                } else {
                    a++;
                    b=0;
                }
            }
        }
        return reshape;
    }
}
