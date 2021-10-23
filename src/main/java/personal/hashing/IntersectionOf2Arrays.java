package personal.hashing;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOf2Arrays {

    public static int NumberofElementsInIntersection(int a[], int b[], int n, int m) {
        Set<Integer> set = new HashSet<>();
        for(int x : a) {
            set.add(x);
        }
        int c =0;
        for(int v:b) {
            if (set.contains(v)) {
                c++;
                set.remove(v);
            }
        }
        return c;
    }
}
