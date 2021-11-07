package personal.arrays;

import java.util.ArrayList;
import java.util.Stack;

public class StockBuyAndSell {


    ArrayList<ArrayList<Integer>> stockBuySell(int arr[], int n) {
        ArrayList<ArrayList<Integer>> sol = new ArrayList<>();
        int i=0,j;
        Stack<Integer> stack = new Stack<>();
        while (i<n) {
            int start = -1;
            if (!stack.empty() && arr[stack.peek()]>= arr[i]) {
                while (!stack.empty())
                start = stack.pop();
            }
            if (start!=-1 && start!=i-1) {
                int finalStart = start;
                int finalI = i;
                sol.add(new ArrayList<Integer>() {{
                    add(finalStart);
                    add(finalI -1);
                }});
            }
            stack.push(i);
            i++;
        }
        if(!stack.empty() && stack.size()>1) {
            int last = stack.pop();
            int start = 0;
            while (!stack.empty()) {
                start = stack.pop();
            }
            int finalStart = start;
            if (start!=n-1)
            sol.add(new ArrayList<Integer>() {{ add(finalStart); add(last);}});
        }
        return sol;
    }
    public static void main(String[] args) {
        int[] A = {11, 42, 49, 96, 23, 20, 49, 26, 26, 18, 73, 2, 53, 59, 34, 99, 25, 2};

        System.out.println(new StockBuyAndSell().stockBuySell(A, 18));
    }
}
