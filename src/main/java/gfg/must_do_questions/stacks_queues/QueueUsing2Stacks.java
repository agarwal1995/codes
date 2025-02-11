package gfg.must_do_questions.stacks_queues;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class QueueUsing2Stacks {

    public static void main(String[] args) throws Exception {
        StackQueue stackQueue = new StackQueue();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] line = bufferedReader.readLine().trim().split("\\s+");
        for (int i=0;i<84;i++) {
            int x = Integer.parseInt(line[i]);
            if (x==1) {
                i++;
                int val = Integer.parseInt(line[i]);
                stackQueue.Push(val);
            } else {
                System.out.println(stackQueue.Pop());
            }
        }
    }


}

class StackQueue
{
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    //Function to push an element in queue by using 2 stacks.
    void Push(int x) {
        while (!s1.empty()) {
            s2.push(s1.pop());
        }
        s1.add(x);
        while (!s2.empty()) {
            s1.push(s2.pop());
        }
    }


    //Function to pop an element from queue by using 2 stacks.
    int Pop() {
        if (s1.empty()) {
            return -1;
        }
        return s1.pop();
    }
}


//class StackQueue
//{
//    Stack<Integer> s1 = new Stack<>();
//    Stack<Integer> s2 = new Stack<>();
//
//    //Function to push an element in queue by using 2 stacks.
//    void Push(int x) {
//        s1.add(x);
//    }
//
//
//    //Function to pop an element from queue by using 2 stacks.
//    int Pop() {
//        if (s2.empty()) {
//            while (!s1.empty()) {
//                s2.push(s1.pop());
//            }
//        }
//        if (s2.empty()) {
//            return -1;
//        }
//        return s2.pop();
//    }
//}
