package interviewBit.bitManipulation;

/**
 * @author raag
 */
public class ReverseBits {

    public long reverse(long a) {
        long result = 0;

        int x = 32;
        while (x>0) {
            long lastBit = a & 1;
            a = a >> 1;
            result = result | lastBit;
            if(x>1) {
                result = result << 1;
            }
            x--;
        }
        return result;
    }
}
