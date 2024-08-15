package interviewBit.queue;

import lombok.Data;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author raag
 */
public class SlidingWindowMaximum {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().trim().split("\\s+");
        List<Integer> list =
                Arrays.stream(line).map(Integer::parseInt).collect(Collectors.toList());
        new SlidingWindowMaximum().slidingMaximum(list, 3);
    }

    public ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
        ArrayList<Integer> result = new ArrayList<>();
        if (A.isEmpty()) {
            return result;
        }
        if(B>A.size()) {
            B = A.size();
        }

        Queue<Pair> maxQueue = new PriorityQueue<Pair>(new Comparator<Pair>() {
            @Override
            public int compare(Pair a, Pair b) {
                return b.val - a.val;
            }
        });

        for (int i=0;i<B;i++) {
            maxQueue.add(new Pair(i, A.get(i)));
        }

        result.add(maxQueue.peek().val);

        for (int i=B;i<A.size();i++) {
            maxQueue.add(new Pair(i, A.get(i)));

            while (maxQueue.peek().ind<=(i-B)) {
                maxQueue.poll();
            }

            result.add(maxQueue.peek().val);
        }
        return result;
    }
}

class Pair {
    int ind;
    int val;

    Pair(int ind, int val) {
        this.ind = ind;
        this.val = val;
    }
}
