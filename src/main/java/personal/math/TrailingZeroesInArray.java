package personal.math;

public class TrailingZeroesInArray {

    static int trailingZeroes(int N){
        int trailingZeroes = 0;
        while (N!=0) {
            trailingZeroes = trailingZeroes + N/5;
            N = N/5;
        }
        return trailingZeroes;
    }

    public static void main(String[] args) {
        System.out.println(trailingZeroes(25));
    }
}
