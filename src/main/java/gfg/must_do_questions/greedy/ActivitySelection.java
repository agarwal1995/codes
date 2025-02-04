package gfg.must_do_questions.greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ActivitySelection {

    public static void main(String[] args) {

    }

    public int activitySelection(List<Integer> start, List<Integer> end) {
        List<Pair1> pairs = new ArrayList<>();
        for (int i=0;i<start.size();i++) {
            pairs.add(new Pair1(start.get(i), end.get(i)));
        }
        pairs.sort(new Comparator<Pair1>() {
            @Override
            public int compare(Pair1 o1, Pair1 o2) {
                if (o1.end == o2.end) {
                    return o1.start - o2.start;
                }
                return o1.end - o2.end;
            }
        });

        int maxActivity = 1;
        int lastEnd = pairs.get(0).getEnd();
        for (int i=1;i<pairs.size();i++) {
            if (pairs.get(i).start>lastEnd) {
                maxActivity++;
                lastEnd = pairs.get(i).getEnd();
            }
        }
        return maxActivity;
    }

}

class Pair1 {
    int start;
    int end;

    public Pair1(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}