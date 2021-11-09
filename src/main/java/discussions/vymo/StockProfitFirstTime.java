package discussions.vymo;

import java.util.Stack;

public class StockProfitFirstTime {

    int[] method(int[] array) {
        int n = array.length;
        int[] sol = new int[n];
        if(n==0) {
            return sol;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for(int i=1;i<n;i++) {
            while(!stack.empty() && array[i] > array[stack.peek()]) {
                int top = stack.pop();
                sol[top] = i - top;
            }
            stack.push(i);
        }
        while(!stack.empty()) {
            sol[stack.pop()] = 0;
        }
        return sol;
    }
}
