package interviewBit.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author raag
 */
public class PowerfulDivisors {



    public static void main(String[] args) {
        new PowerfulDivisors().powerfulDivisors(new ArrayList<>(Arrays.asList(5,10)));
    }


    boolean[] isPowerOf2Factors = new boolean[100001];

    public ArrayList<Integer> powerfulDivisors(ArrayList<Integer> A) {
        int max = A.stream().max(Comparator.naturalOrder()).orElse(0) + 1;
        calculateDivisors(max);
        ArrayList<Integer> result = new ArrayList<>();
        int[] cumalative = new int[max];
        for (int i=1;i<max;i++) {
            cumalative[i] = cumalative[i-1] + (isPowerOf2Factors[i]?1:0);
        }

        for (int x:A) {
            result.add(cumalative[x]);
        }
        return result;
    }

    private void calculateDivisors(int max) {
        for (int i=1;i<=max;i++) {
            int k=0;
            int x = 0;
            for (int j=1;j<=(i/2);j++) {
                if (i%j==0) {
                    x++;
                }
            }
            x = x+1;
            while (x!=0) {
                k = k + (x&1);
                if (k>1){
                    break;
                }
                x = x>>1;
            }
            isPowerOf2Factors[i] = k == 1;
        }
    }
}
