package interviewBit.stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author raag
 */
public class MAXSPPROD {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().trim().split("\\s+");
        List<Integer> list =
                Arrays.stream(line).map(Integer::parseInt).collect(Collectors.toList());
        System.out.println(new MAXSPPROD().maxSpecialProduct(new ArrayList<>(list)));
    }
    public int maxSpecialProduct(ArrayList<Integer> A) {
        // create LSpecialArray
        Stack<Integer> stack = new Stack<>();
        List<Integer> lSpecialArray = new ArrayList<>();
        for (int i=0;i<A.size();i++) {
            while (!stack.isEmpty() && A.get(stack.peek()) <= A.get(i)) {
                stack.pop();
            }
            if (stack.empty()) {
                lSpecialArray.add(0);
            } else  {
                lSpecialArray.add(stack.peek());
            }
            stack.push(i);
        }
        stack.clear();

        long mod = (long) (1e9+7);
        List<Integer> rSpecialArray = new ArrayList<>();
        for (int i=A.size()-1;i>=0;i--) {
            while (!stack.isEmpty() && A.get(stack.peek()) <= A.get(i)) {
                stack.pop();
            }
            if (stack.empty()) {
                rSpecialArray.add(0);
            } else  {
                rSpecialArray.add(stack.peek());
            }
            stack.push(i);
        }
        Collections.reverse(rSpecialArray);

        Long maxProduct = 0l;

        for (int i=0;i<A.size();i++) {
            maxProduct = Math.max((lSpecialArray.get(i)%mod)*(rSpecialArray.get(i)%mod), maxProduct);
            maxProduct = maxProduct%mod;
        }
        return (int)(maxProduct%mod);
    }
}
