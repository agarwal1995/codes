package interviewBit.math;

/**
 * @author raag
 */
public class GridUniquePaths {

    public int uniquePaths(int A, int B) {
        int[][] array = new int[A][B];
        for (int i=0;i<B;i++) {
            array[0][i]=1;
        }
        for (int i=0;i<A;i++) {
            array[i][0]=1;
        }
        for (int i=1;i<A;i++) {
            for (int j=1;j<B;j++) {
                array[i][j] = array[i-1][j] + array[i][j-1];
            }
        }
        return array[A-1][B-1];
    }
}


