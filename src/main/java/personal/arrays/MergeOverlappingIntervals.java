package personal.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MergeOverlappingIntervals {

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        intervals.sort(Comparator.comparingInt(o -> o.start));
        int n = intervals.size();

        ArrayList<Interval> sol = new ArrayList<>();
        sol.add(intervals.get(0));
        for (int i = 1; i < n; i++) {
            Interval previous = sol.get(sol.size()-1);
            Interval current = intervals.get(i);
            if(previous.end >= current.start) {
                previous.end = Math.max(previous.end, current.end);
            } else {
                sol.add(current);
            }
        }
        System.out.println(sol);
        return intervals;
    }
    public static void main(String[] args) {
        ArrayList<Interval> list = new ArrayList<>();
        list.add(new Interval(2,6));
        list.add(new Interval(8,10));
        list.add(new Interval(1,3));
        list.add(new Interval(15,18));
        new MergeOverlappingIntervals().merge(list);
    }

    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}
