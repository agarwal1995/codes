package leetcode.studyplan.datastructure.first;

import java.util.Stack;

public class ValidParanthesis {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            if(ch=='(' || ch=='{' || ch == '[') {
                stk.push(ch);
            } else {
                if(stk.empty()) {
                    return false;
                }
                char ch2 = stk.pop();
                switch(ch2) {
                    case '(':
                        if(ch!=')') {
                            return false;
                        }
                        break;
                    case '{':
                        if(ch!='}') {
                            return false;
                        }
                        break;
                    case '[':
                        if(ch!=']') {
                            return false;
                        }
                        break;
                }
            }

        }
        if(!stk.empty()) {
            return false;
        }
        return true;
    }
}
