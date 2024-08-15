package interviewBit.bitManipulation;

/**
 * @author raag
 */
public class TrailingZeros {

    public static void main(String[] args) {

    }

    public int solve(int A) {
        int count = 0;
        while (A!=0) {
            int y = A & 1;
            if (y==0) {
                count++;
            } else {
                break;
            }
            A = A >> 1;
        }
        return count;
    }
}
