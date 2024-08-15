package interviewBit.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author raag
 */
public class MergeOverlappingIntervals {

    public static void main(String[] args) {

    }

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> result = new ArrayList<>();
        intervals.sort((interval, t1) -> interval.start - t1.start);

        result.add(intervals.get(0));
        for (int i=1;i<intervals.size();i++) {
            int j = result.size();
            Interval interval = intervals.get(i);
            if (interval.start>=result.get(i-1).end) {
                result.get(j-1).end = Math.max(interval.end, result.get(j-1).end);
            } else {
                result.add(interval);
            }
        }
        return result;
    }
}
