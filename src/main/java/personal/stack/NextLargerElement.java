package personal.stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class NextLargerElement {

    public static void nextLargerElements(int[] arr) {
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int i=1;i<n;i++) {
            while (!stack.empty() && arr[stack.peek()] < arr[i]) {
                int pop = stack.pop();
                arr[pop] = arr[i];
            }
            stack.push(i);
        }

        while (!stack.empty()) {
            arr[stack.pop()] = -1;
        }
        System.out.println(Arrays.toString(arr));
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().trim().split("\\s+");
        int[] arr = new int[line.length];
        for(int i=0;i<arr.length;i++) {
            arr[i] = Integer.parseInt(line[i]);
        }
        nextLargerElements(arr);
    }
}
