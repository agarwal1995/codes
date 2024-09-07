package interviewBit.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author raag
 */
public class SumOfFibonacciNumbers {

    public static void main(String[] args) {

        System.out.println(new SumOfFibonacciNumbers().fibsum(4));
        System.out.println(new SumOfFibonacciNumbers().fibsum(7));

    }

    public int fibsum(int A) {
        List<Integer> fibList = new ArrayList<>();
        fibList.add(1);
        fibList.add(1);

        for (int i=2; fibList.get(i-1)<A;i++) {
            fibList.add(fibList.get(i-1) + fibList.get(i-2));
        }

        int c = 0;
        int n = fibList.size()-1;
        while (n>0) {
            if (A>=fibList.get(n)) {
                A = A - fibList.get(n);
                c++;
            }
            if (A==0){
                return c;
          }
            n--;
        }
        return c;
    }
}
