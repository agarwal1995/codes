package interviewBit.bitManipulation;

import java.util.List;

/**
 * @author raag
 */
public class SingleNumberII {

    public int singleNumber(final List<Integer> a) {
        int[] bits = new int[32];
        for (int x:a) {
            for (int i=0;i<31;i++) {
                bits[i] = bits[i] + (x & 1);
                x = x>>1;
            }
        }
        int[] res = new int[32];
        int i = 0;
        for (int x:bits) {
            res[31-i] = x%3==0?0:1;
            i++;
        }

        int decimalResult = 0;
        int power = res.length - 1;

        for (int bit : res) {
            decimalResult += (int) (bit * Math.pow(2, power));
            power--;
        }
        return decimalResult;
    }
}
