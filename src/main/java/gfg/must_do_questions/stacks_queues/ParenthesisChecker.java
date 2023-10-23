package gfg.must_do_questions.stacks_queues;

import java.util.Stack;

/**
 * @author raag
 */
public class ParenthesisChecker {

    //Function to check if brackets are balanced or not.
    static boolean ispar(String x) {
        Stack<Character> stack = new Stack<>();
        int n = x.length();
        int i=0;
        while (i<n) {
            char ch = x.charAt(i);
            i++;
            if(ch=='{' || ch == '(' || ch == '[') {
                stack.push(ch);
            } else if (stack.empty()) {
                return false;
            } else {
                char topCharacter = stack.pop();
                if(ch == '}' && topCharacter!='{'
                || ch == ']' && topCharacter!='['
                || ch == ')' && topCharacter!='(') {
                    return false;
                }
            }
        }
        if(!stack.empty()) {
            return false;
        }
        return true;
    }


    public static void main(String[] args) {

    }
}
