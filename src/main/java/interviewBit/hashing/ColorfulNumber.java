package interviewBit.hashing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ColorfulNumber {
    public int colorful(int A) {
        List<Integer> list = new ArrayList<>();
        int n=0;
        while (A>0) {
            list.add(A%10);
            A = A/10;
            n++;
        }
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++) {
            int prod = 1;
            for(int j=i;j<n;j++) {
                prod = prod * list.get(j);
                if(set.contains(prod)) {
                    return 0;
                }
                set.add(prod);
            }
        }
        return 1;
    }
}
