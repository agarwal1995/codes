package personal.stacjs;

import java.util.Arrays;
import java.util.Stack;

public class StockSpanProblem {

    public static int[] calculateSpan(int price[], int n) {
        Stack<Integer> stack = new Stack<>();

        int[] sol = new int[n];
        for (int i=0;i<n;i++) {
            while (!stack.empty() && price[stack.peek()] <= price[i]) {
                stack.pop();
            }
            sol[i] = stack.empty() ? i +1 : i - stack.peek();
            stack.push(i);
        }
        return sol;
    }

    public static void main(String[] args) {
        int[] arr = {100,80,60,70,60,75,85};
        System.out.println(Arrays.toString(calculateSpan(arr, 7)));
    }
}
