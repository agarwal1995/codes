package personal.stack;

import java.util.Stack;

public class MaxRectangularArea {

    public static long getMaxArea(long hist[], long n) {
        Stack<Integer> stack = new Stack<>();

        long maxArea = Integer.MIN_VALUE;

        for (int i=0;i<n;i++) {
            while (!stack.empty() && hist[stack.peek()] > hist[i]) {
                int index = stack.pop();
                int len = stack.empty() ? i : i - stack.peek()-1;
                long area = len * hist[index];
                maxArea = Math.max(maxArea, area);
            }
            stack.push(i);
        }
        while (!stack.empty()) {
            int index = stack.pop();
            long len = stack.empty() ? n : (n - stack.peek() -1);
            long area = len * hist[index];
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    public static void main(String[] args) throws Exception {
        long arr[] = {6,2,5,4,5,1,6};
        System.out.println(getMaxArea(arr, 7));
    }
}
