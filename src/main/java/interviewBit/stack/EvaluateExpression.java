package interviewBit.stack;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * @author raag
 */
public class EvaluateExpression {

    public static void main(String[] args) {

        System.out.println(new EvaluateExpression().evalRPN(new ArrayList<>(Arrays.asList("2","1","+","3","*"))));
        System.out.println(new EvaluateExpression().evalRPN(new ArrayList<>(Arrays.asList("5","1","2","+","4","*","+","3","-"))));

    }

    public int evalRPN(ArrayList<String> list) {

        Stack<String> stack = new Stack<>();
        for (int i=list.size()-1;i>=0;i--) {
            if (list.get(i).equals("+") || list.get(i).equals("-") || list.get(i).equals("*") || list.get(i).equals("/")) {
                stack.push(list.get(i));
                continue;
            }
            int res = Integer.parseInt(list.get(i));
            while (!stack.empty() && isNumeric(stack.peek())) {
                int x = res;
                int y = Integer.parseInt(stack.pop());
                String sign = stack.pop();
                switch (sign) {
                    case "+": res = x+y;
                        break;
                    case "-": res = x-y;
                        break;
                    case "*": res = x*y;
                        break;
                    case "/": res = x/y;
                        break;
                }
            }
            stack.push(String.valueOf(res));
        }
        if (stack.size()>2) {
            int x = Integer.parseInt(stack.pop());
            int y = Integer.parseInt(stack.pop());
            String sign = stack.pop();
            int res = 0;
            switch (sign) {
                case "+": res = x+y;
                    break;
                case "-": res = x-y;
                    break;
                case "*": res = x*y;
                    break;
                case "/": res = x/y;
                    break;
            }
            return res;
        }
        return Integer.parseInt(stack.peek());
    }

    private boolean isNumeric(String x) {
        try {
            Integer.parseInt(x);
        } catch (Exception e) {
           return false;
        }
        return true;
    }
}
