package gfg.must_do_questions.stacks_queues;

import java.util.Stack;

/**
 * @author raag
 */
public class GetMinimumElementFromStack {
     int minEle;
     Stack<Integer> s;

     // Constructor
     GetMinimumElementFromStack() {
         s = new Stack<>();
         minEle =1;
     }

     /*returns min element from stack*/
     int getMin() {
         if(s.empty()) {
             return -1;
         }
         return s.peek();
         // Your code here
     }

     /*returns poped element from stack*/
     int pop() {
         if(s.empty()) {
             return -1;
         }
         return s.pop();
         // Your code here
     }

     /*push element x into the stack*/
     void push(int x) {
         if(s.empty()) {
             s.push(x);
         } else {
             s.push(Math.min(s.peek(), x));
         }
     }
}

