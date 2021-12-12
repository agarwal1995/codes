package personal.dp;

public class NumberOfWaysToCoverADistance {
    static long countWays(int n) {
        int modulo = 1000000007;
        long[] arr = new long[3];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 4;
        if (n<=3) {
            return arr[n-1];
        }
        for(int i=0;i<n-3;i++) {
            long c = (arr[0] + arr[1] + arr[2])%modulo;
            arr[0] = arr[1];
            arr[1] = arr[2];
            arr[2] = c;
        }
        return arr[2];
    }

    public static void main(String[] args) {
        System.out.println(countWays(54));
    }
}
