package personal.stacjs;

import java.util.Stack;

public class LongestValidParenthesis {

    static int maxLength(String str) {
        int curr = 0;
        int max = Integer.MIN_VALUE;

        Stack<Character> stack = new Stack<>();
        for (int i=0;i<str.length();i++) {
            if (str.charAt(i) == '(') {
                stack.push('(');
            } else {
                if(stack.empty()) {
                    curr = 0;
                } else {
                    stack.pop();
                    curr = curr + 2;
                }
            }
            max = Math.max(curr, max);
        }

        return max;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(maxLength("()(()))))"));
    }
}
