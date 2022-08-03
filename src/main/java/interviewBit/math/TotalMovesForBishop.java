package interviewBit.math;

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

//        1 2 3 4 5 6 7 8
//        1 2 3 4 5 6 7 8
//        1 2 3 4 5 6 7 8
//        1 2 3 4 5 6 7 8
//        1 2 3 4 5 6 7 8
//        1 2 3 4 5 6 7 8
//        1 2 3 4 5 6 7 8
//        1 2 3 4 5 6 7 8

