package interviewBit.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PairsWithGivenXOR {

    public int solve(ArrayList<Integer> A, int B) {

        int count = 0;
        Set<Integer> set = new HashSet<>();
        for(int x:A) {
            if(set.contains(B^x)) {
                count++;
                set.remove(B^x);
            } else {
                set.add(x);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Integer[] a = { 17, 18, 8, 13, 15, 7, 11, 5, 4, 9, 12, 6, 10, 14, 16, 3};
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(a));
        System.out.println(new PairsWithGivenXOR().solve(list, 9));
    }
}
