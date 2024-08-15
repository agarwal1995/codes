package interviewBit.binarySearch;

import java.util.ArrayList;

/**
 * @author raag
 */
public class WoodCuttingMakeEasy {

    public int solve(ArrayList<Integer> list, int b) {
        int l = Integer.MAX_VALUE;
        int r = Integer.MIN_VALUE;

        for (int x: list) {
            l = Math.min(l, x);
            r = Math.max(r, x);
        }


        int height = 0;
        long woodSum = 0;
        while (l<=r) {
            int mid = (l+r)/2;
            long sum = calculateWoodAtH(list, mid);
            if (sum == b) {
                return mid;
            }
            if (sum>b) {
                if (height ==0 || woodSum> sum) {
                    woodSum = sum;
                    height = mid;
                }
                l = mid+1;
            } else {
                r = mid-1;
            }
        }
        return height;
    }

    private long calculateWoodAtH(ArrayList<Integer> list,  int h) {
        long sum = 0;
        for (int x:list) {
            if (x>h) {
                sum = sum+(x-h);
            }
        }
        return sum;
    }
}
