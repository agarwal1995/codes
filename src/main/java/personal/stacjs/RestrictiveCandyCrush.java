package personal.stacjs;

import java.util.Stack;

public class RestrictiveCandyCrush {

    public static String reduced_String(int k, String s) {
        Stack<RCCObject> stack = new Stack<>();
        int n = s.length();
        if(k==1) {
            return "";
        }
        RCCObject prevObj = null;
        for(int i=0;i<n;i++) {
            char currChar = s.charAt(i);
            RCCObject currObject = new RCCObject(currChar, 1);
            if (stack.empty()) {
                stack.push(currObject);
            } else {
                RCCObject topObject = stack.peek();
                if (topObject.ch == currChar && topObject.count +1 == k) {
                    while (!stack.empty()  &&  stack.peek().ch==currChar) {
                        stack.pop();
                    }
                    continue;
                }
                if (topObject.ch == currChar) {
                    currObject.count = topObject.count + 1;
                }
                stack.push(currObject);
            }
        }
        StringBuilder sbr = new StringBuilder();
        while (!stack.empty()) {
            sbr.append(stack.pop().ch);
        }
        sbr.reverse();
        return sbr.toString();
    }

    public static void main(String[] args) {
        System.out.println(reduced_String(2,"geegsforgeeeks"));
    }
}


class RCCObject {
    public char ch;
    public int count;

    public RCCObject(char ch, int count) {
        this.ch = ch;
        this.count = count;
    }
}