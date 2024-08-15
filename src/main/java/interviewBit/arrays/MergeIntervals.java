package interviewBit.arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author raag
 */
public class MergeIntervals {

    public static void main(String[] args) throws Exception {
        Interval i1 = new Interval(1,2);
        Interval i2 = new Interval(3,5);
        Interval i3 = new Interval(6,7);
        Interval i4 = new Interval(8,10);
        Interval i5 = new Interval(12, 16);

//        Interval newInterval = new Interval(36210193,61984219);
        Interval newInterval = new Interval(3,10);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().trim().split(",");
        ArrayList<Interval> intervals = new ArrayList<>();
        for (int i=0;i<4;) {
            Interval interval = new Interval(Integer.parseInt(s[i++]), Integer.parseInt(s[i++]));
            intervals.add(interval);
        }
        new MergeIntervals().insert(intervals, newInterval);
    }

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> sol = new ArrayList<>();
        if (intervals.isEmpty()) {
            sol.add(newInterval);
            return sol;
        }

        if (intervals.get(0).start > newInterval.end) {
            sol.add(newInterval);
            sol.addAll(intervals);
            return sol;
        }

        if (intervals.get(intervals.size()-1).end < newInterval.start) {
            sol.addAll(intervals);
            sol.add(newInterval);
            return sol;
        }

        boolean isCurrentIncluded = false;
        for (int i=0;i<intervals.size();i++) {
            Interval current = intervals.get(i);
            if (current.end<newInterval.start) {
                sol.add(current);
                continue;
            }
            if(current.start > newInterval.end) {
                if (!isCurrentIncluded) {
                    sol.add(newInterval);
                }
                isCurrentIncluded = true;
                sol.add(current);
                continue;
            }
//            if (isCurrentIncluded && ) {
//            }
            Interval prevStart = current;
            Interval prev = current;
            if (current.end > newInterval.start) {
                while (current.start < newInterval.end) {
                    prev = current;
                    i++;
                    if (i>=intervals.size()) {
                        break;
                    }
                    current = intervals.get(i);
                }
                Interval interval = new Interval();
                interval.start = Math.min(prevStart.start, newInterval.start);
                interval.end = Math.max(prev.end, newInterval.end);
                sol.add(interval);
                isCurrentIncluded = true;
                if (interval.end>= current.end && interval.start<= current.start) {
                    continue;
                }
                sol.add(current);
            }
        }
        return sol;
    }
}

class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }