package personal.math;

import java.util.HashSet;
import java.util.Set;

public class SmallestSumThatCantBe {

    public static long sumBruteForce(long[] array, int n) {
        Set<Long> sumSets = new HashSet<>();
        sumBruteForceUtil(sumSets, array, 0, n, 0);
        System.out.println(sumSets);
        long k=1;
        while (true) {
            if(!sumSets.contains(k)) {
                return k;
            }
            k++;
        }
    }

    private static void sumBruteForceUtil(Set<Long> set, long[] array, long sum, int n, int i) {
        if(i==n) {
            set.add(sum);
            return;
        }
        sumBruteForceUtil(set, array, sum + array[i], n, i+1);
        sumBruteForceUtil(set, array, sum, n, i+1);
    }

    public static void main(String[] args) {
//        long[] array = {1,10,3,11,6,15};
        long[] array = {1,1,3,5,8,21};
        System.out.println(sumBruteForce(array, 6));
    }
}
