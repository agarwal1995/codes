package interviewBit.math;

/**
 * Given the position of a Bishop (A, B) on an 8 * 8 chessboard.
 * Your task is to count the total number of squares that can be visited by the Bishop in one move.
 * The position of the Bishop is denoted using row and column number of the chessboard.
 * @author raag
 */
public class TotalMovesForBishop {
    public int solve(int A, int B) {
        System.out.println(Math.min(A-1, B-1));
        System.out.println(Math.min(8-A, B-1));
        System.out.println(Math.min(8-A, 8-B));
        System.out.println(Math.min(A-1, 8-B));
        return Math.min(A-1, B-1) + Math.min(8-A, B-1) + Math.min(8-A, 8-B) + Math.min(A-1, 8-B);
    }

    public static void main(String[] args) {
        System.out.println(new TotalMovesForBishop().solve(4,4));
    }
}
