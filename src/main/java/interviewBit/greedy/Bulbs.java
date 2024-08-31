package interviewBit.greedy;

import java.util.ArrayList;

/**
 *
 * N light bulbs are connected by a wire.
 * Each bulb has a switch associated with it, however due to faulty wiring, a switch also changes the state of all the bulbs to the right of current bulb.
 * Given an initial state of all bulbs, find the minimum number of switches you have to press to turn on all the bulbs.
 * You can press the same switch multiple times.
 * Note : 0 represents the bulb is off and 1 represents the bulb is on.
 *
 * @author raag
 */
public class Bulbs {

    public static void main(String[] args) {

    }


    /**
     * Given an initial state of all bulbs, find the minimum number of switches you have to press to turn on all the bulbs.
     * You can press the same switch multiple times.
     * Note : 0 represents the bulb is off and 1 represents the bulb is on.
     * @param A initial state of all bulbs
     * @return the minimum number of switches you have to press to turn on all the bulbs
     */
    public int bulbs(ArrayList<Integer> A) {
        int presses = 0;
        // iterate through the bulbs
        for (int x:A) {
            // if the bulb is off and the number of presses is even, increment the number of presses
            if (x==0 && presses%2==0) {
                presses++;
                // don't increment the presses counter again
                continue;
            }
            // if the bulb is on and the number of presses is odd, increment the number of presses
            if (x==1 && presses%2==1) {
                presses++;
            }
        }
        return presses;
    }
}
