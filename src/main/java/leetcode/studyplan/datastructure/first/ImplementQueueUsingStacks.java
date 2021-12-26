package leetcode.studyplan.datastructure.first;

import java.util.Stack;

public class ImplementQueueUsingStacks {

    Stack<Integer> stk1;
    Stack<Integer> stk2;

    public ImplementQueueUsingStacks() {
        stk1 = new Stack<>();
        stk2 = new Stack<>();
    }

    public void push(int x) {
        stk1.push(x);
    }

    public int pop() {
        if(!stk2.empty()) {
            return stk2.pop();
        }
        while(!stk1.empty()) {
            stk2.push(stk1.pop());
        }
        return stk2.pop();
    }

    public int peek() {
        if(!stk2.empty()) {
            return stk2.peek();
        }
        while(!stk1.empty()) {
            stk2.push(stk1.pop());
        }
        return stk2.peek();
    }

    public boolean empty() {
        return stk1.empty() && stk2.empty();
    }
}
