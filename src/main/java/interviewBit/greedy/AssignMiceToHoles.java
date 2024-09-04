package interviewBit.greedy;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * There are N Mice and N holes that are placed in a straight line. Each hole can accommodate only 1 mouse.
 * The positions of Mice are denoted by array A and the position of holes are denoted by array B.
 * A mouse can stay at his position, move one step right from x to x + 1, or move one step left from x to x − 1. Any of these moves consumes 1 minute.
 * Assign mice to holes so that the time when the last mouse gets inside a hole is minimized.
 * @author raag
 */
public class AssignMiceToHoles {

    public static void main(String[] args) {

    }

    public int mice(ArrayList<Integer> A, ArrayList<Integer> B) {
        A.sort(Comparator.naturalOrder());
        B.sort(Comparator.naturalOrder());
        int max = 0;

        for (int i=0;i<A.size();i++) {
            max = Math.max(max, Math.abs(A.get(i)-B.get(i)));
        }
        return max;
    }
}
