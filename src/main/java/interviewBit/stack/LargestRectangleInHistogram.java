package interviewBit.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * @author raag
 */
public class LargestRectangleInHistogram {

    public static void main(String[] args) {
        new LargestRectangleInHistogram().largestRectangleArea(new ArrayList<>(Arrays.asList(2,1,5,6,2,3)));
        new LargestRectangleInHistogram().largestRectangleArea(new ArrayList<>(Arrays.asList(6, 2, 5, 4, 5, 1, 6)));
        new LargestRectangleInHistogram().largestRectangleArea(new ArrayList<>(Arrays.asList(1)));
    }

    public int largestRectangleArea(ArrayList<Integer> A) {
        Stack<Integer> stack = new Stack<>();

        int max = Integer.MIN_VALUE;

        for (int i=0;i<A.size();) {
            if (!stack.isEmpty() && A.get(stack.peek())>A.get(i)) {
                int tp = stack.pop();
                int area = (stack.empty()?A.size():A.size()- stack.peek()-1) * A.get(tp);
                max = Math.max(area, max);
            } else {
                stack.push(i);
                i++;
            }
        }

        while (!stack.isEmpty()) {
            int n = stack.pop();
            int area = (stack.empty()?A.size():A.size()- stack.peek()-1) * A.get(n);
            max = Math.max(area, max);
        }

        return max;
    }
}

// 6, 2, 5, 4, 5, 1, 6


