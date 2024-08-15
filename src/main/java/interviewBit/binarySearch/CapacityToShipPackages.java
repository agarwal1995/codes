package interviewBit.binarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author raag
 */
public class CapacityToShipPackages {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().trim().split("\\s+");
        List<Integer> weights =
                Arrays.stream(line).map(Integer::parseInt).collect(Collectors.toList());
        System.out.println(new CapacityToShipPackages().solve(new ArrayList<>(weights), 5));
    }

    public int solve(ArrayList<Integer> list, int B) {
        int low = Integer.MIN_VALUE;
        int high = 0;

        for (int x:list) {
            high = high+x;
            low = Math.max(low, x);
        }
        int ans = -1;
        while (low<=high) {
            int mid = low + (high-low)/2;
            int daysToPort = calculateDays(list, mid);
            if (daysToPort>=B) {
                if (daysToPort==B) {
                    ans = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                ans = mid;
                high = mid-1;
            }
        }
        return ans;
    }

    private int calculateDays(ArrayList<Integer> list, int capacity) {
        int days = 0;
        int weightTillNow = 0;
        for (int x:list) {
            weightTillNow = weightTillNow+x;
            if (weightTillNow>=capacity) {
                days++;
                if (weightTillNow == capacity) {
                    weightTillNow = 0;
                } else {
                    weightTillNow = x;
                }
            }
        }
        return days + (weightTillNow>0?1:0);
    }
}
