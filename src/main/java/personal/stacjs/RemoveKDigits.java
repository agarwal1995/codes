package personal.stacjs;

import java.util.Stack;

public class RemoveKDigits {

    public String removeKdigits(String str, int k) {
        Stack<Integer> stack = new Stack<>();

        int i=0, n = str.length();
        while (i < n) {
            while (k!=0 && !stack.empty() && str.charAt(i) < str.charAt(stack.peek())) {
                stack.pop();
                k--;
            }
            stack.push(i);
            i++;
        }
        if(k!=0) {
            while (k!=0 && !stack.empty()) {
                stack.pop();
                k--;
            }
        }
        StringBuilder sbr = new StringBuilder();
        while (!stack.empty()) {
            sbr.append(str.charAt(stack.pop()));
        }

        return sbr.reverse().toString().replaceFirst("^0+(?!$)", "");
    }

    public static void main(String[] args) {
        System.out.println(new RemoveKDigits().removeKdigits("1002991",3));
    }
}
