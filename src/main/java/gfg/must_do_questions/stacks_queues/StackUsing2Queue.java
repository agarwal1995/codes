package gfg.must_do_questions.stacks_queues;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsing2Queue {

    public static void main(String[] args) {

    }
}

class Queues
{
    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<>();

    //Function to push an element into stack using two queues.
    void push(int a) {
        while (!q1.isEmpty()) {
            q2.add(q1.poll());
        }
        q1.add(a);

        while (!q2.isEmpty()) {
            q1.add(q2.poll());
        }
        // Your code here
    }

    //Function to pop an element from stack using two queues.
    int pop() {
        if (q1.isEmpty()) {
            return -1;
        }
        return q1.poll();
    }

}


