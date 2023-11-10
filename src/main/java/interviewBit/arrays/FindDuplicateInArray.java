package interviewBit.arrays;

import java.util.List;

public class FindDuplicateInArray {
    /* No Duplicate value */
    public int repeatedNumber(final List<Integer> a) {
        int n = a.size();
        int[] ar = new int[n];
        for(int x:a){
            if(ar[x]!=0){
                return x;
            }
            ar[x]=1;
        }
        return -1;
    }
}
