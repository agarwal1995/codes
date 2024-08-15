package interviewBit.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author raag
 */
public class RainWaterTrapped {

    public static void main(String[] args) {
        new RainWaterTrapped().trap(Arrays.asList(0,1,0,2,1,0,1,3,2,1,2,1));
    }

    public int trap(final List<Integer> A) {
        List<Integer> leftMax = new ArrayList<>();
        List<Integer> rightMax = new ArrayList<>();
        leftMax.add(A.get(0));
        rightMax.add(A.get(A.size()-1));

        int n = A.size();
        for (int i=1, j=n-2;i<n;i++, j--) {
            leftMax.add(Math.max(A.get(i), leftMax.get(leftMax.size()-1)));
            rightMax.add(Math.max(A.get(j), rightMax.get(rightMax.size()-1)));
        }
        Collections.reverse(rightMax);

        int waterTrapped = 0;
        for (int i=1;i<n-1;i++) {
            int currentWaterHold = Math.min(leftMax.get(i-1), rightMax.get(i+1)) - A.get(i);
            waterTrapped = waterTrapped + (currentWaterHold>0? currentWaterHold:0);
        }
        return waterTrapped;
    }
}
