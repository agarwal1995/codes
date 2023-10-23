package gfg.must_do_questions.stacks_queues;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author raag
 */
public class NextGreaterElement {

    public static long[] nextLargerElement(long[] arr, int n) {
        Stack<Long> stack = new Stack<>();

        long[] result = new long[n];
        int i=n-1;
        while (i>=0) {
            if(stack.empty()) {
                result[i] = -1;
//                stack.push(arr[i]);
            } else {
                while (!stack.empty() && (stack.peek() <= arr[i])) {
                    stack.pop();
                }
                if(stack.empty()) {
                    result[i] = -1;
                } else {
                    result[i] = stack.peek();
                }
            }
            stack.push(arr[i]);
            i--;
        }
        System.out.println(Arrays.toString(result));
        return result;
    }

    public static void main(String[] args) {
        nextLargerElement(new long[]{1,3,2,4}, 4);
        nextLargerElement(new long[]{10,8,9,11}, 4);
        nextLargerElement(new long[]{6,8,0,1,3}, 5);
        nextLargerElement(new long[]{6273,6273,8726,8726,5881,5881,1953,1953,8305,8305,9909,9909,5936,5936,4961,4961,7822,7822,4622,4622,2296,2296,2185,2185,2573,2573,7708,7708,4702,4702,2861,2861,7107,7107,2428,2428,6388,6388,6818,6818,33,33,8346,8346,3061,3061,5361,5361,275,275,2461,2461,6275,6275,8306,8306,2493,2493,302,302,9528,9528,4165,4165,7621,7621,6805,6805,1371,1371,9916,9916,3082,3082,5113,5113,3550,3550,6564,6564,8651,8651,5165,5165,3823,3823,6814,6814,8179,8179,2902,2902,2410,2410,1549,1549,4405,4405,5238,5238},
                100);
    }
}
