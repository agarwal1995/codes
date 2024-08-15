package interviewBit.math;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author raag
 */
public class RearrangeArray {

    public static void main(String[] args) {
        new RearrangeArray().arrange(new ArrayList<>(Arrays.asList(0,2,1,3)));
    }

    public void arrange(ArrayList<Integer> a) {
        int n = a.size();
        for (int i=0;i<n;i++) {
            a.set(i, a.get(i)*n);
        }

//        System.out.println(a);
        for (int i=0;i<n;i++) {
            a.set(i, (a.get(a.get(i)/n)/n) + a.get(i));
        }

//        System.out.println(a);
        for (int i=0;i<n;i++) {
            a.set(i, a.get(i)%n);
        }
//        System.out.println(a);
    }
}
