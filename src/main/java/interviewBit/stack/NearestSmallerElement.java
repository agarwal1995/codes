package interviewBit.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * @author raag
 */
public class NearestSmallerElement {

    public static void main(String[] args) {
        new NearestSmallerElement().prevSmaller(new ArrayList<>(Arrays.asList(4,5,2,7,9)));
    }

    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        Stack<Integer> stack = new Stack<>();

        ArrayList<Integer> result = new ArrayList<>();

        for (int i=0;i<A.size();i++) {
            int currentElement = A.get(i);
            while (!stack.empty() && currentElement<=stack.peek()) {
                stack.pop();
            }
            if (stack.empty()) {
                result.add(-1);
            } else {
                result.add(stack.peek());
            }
            stack.push(A.get(i));
        }
        return result;
    }
}
