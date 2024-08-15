package interviewBit.bitManipulation;

/**
 * @author raag
 */
public class CountTotalSetBits {

    public static void main(String[] args) {
        System.out.println(new CountTotalSetBits().solve(3));
    }

    public int solve(int A) {
        int mod = 1000000007;
        int sum = 0;
        for (int i=1;i<=A;i++) {
            Integer.bitCount(1);
            int k = i;
            for (int j=1;j<32 && k!=0;j++) {
                int x = k & 1;
                sum = (sum + x);
                k = k >> 1;
            }
            sum = sum %mod;
        }
        return sum;
    }
}
