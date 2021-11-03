package personal.skillenja;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class CargoDroppingShips {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sbr = new StringBuilder();
        while (t>0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] line = br.readLine().trim().split("\\s+");
            int[] array = new int[n];
            for(int i=0;i<n;i++) {
                array[i] = Integer.parseInt(line[i]);
            }
            if(n==1) {
                sbr.append(array[0]).append("\n");
                t--;
                continue;
            }
            int minInGroup = Integer.MAX_VALUE;
            boolean flagForLarge = false;
            int sum = 0;

            int i = 0;
            Stack<Integer> stk = new Stack<>();
            if(array[0]<array[1]) {
                flagForLarge = true;
            }
            while (i<n) {
                if (flagForLarge) {
                    if(stk.empty() || array[i] > array[stk.peek()]) {
                        stk.push(i);
                        i++;
                        minInGroup = Math.min(minInGroup, array[stk.peek()]);
                        continue;
                    }
                } else {
                    if(stk.empty() || array[i] < array[stk.peek()]) {
                        stk.push(i);
                        i++;
                        minInGroup = Math.min(minInGroup, array[stk.peek()]);
                        continue;
                    }
                }
                sum = sum + (stk.size() * minInGroup);
                flagForLarge = !flagForLarge;
                i--;
                minInGroup = Integer.MAX_VALUE;
                stk.clear();
            }

            if(!stk.empty()) {
                sum = sum + (stk.size() * minInGroup);
            }
            sbr.append(sum).append("\n");
            t--;
        }
        System.out.println(sbr.toString());
    }
}
