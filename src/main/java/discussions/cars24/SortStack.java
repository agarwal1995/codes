package discussions.cars24;

import java.util.Stack;

public class SortStack {

    private void sortStack(Stack<Integer> ogStack) {
        Stack<Integer> bufferStack = new Stack<>();

        while (!ogStack.empty()) {
            int topOg = ogStack.pop();
            while (!bufferStack.empty() && bufferStack.peek() > topOg) {
                int topBuffer = bufferStack.pop();
                ogStack.push(topBuffer);
            }
            bufferStack.push(topOg);
        }


        System.out.println(bufferStack);

        while (!bufferStack.empty()) {
            ogStack.push(bufferStack.pop());
        }
        System.out.println(ogStack);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(3);
        stack.push(5);
        new SortStack().sortStack(stack);
    }
}
