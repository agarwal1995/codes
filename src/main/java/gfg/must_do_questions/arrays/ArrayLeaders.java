package gfg.must_do_questions.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ArrayLeaders {

    public ArrayList<Integer> solve(int[] ar) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int x:ar){
            arr.add(x);
        }
        int n = arr.size();
        ArrayList<Integer> leaders = new ArrayList<>();
        leaders.add(arr.get(n-1));
        int maxTillNow = arr.get(n-1);
        for(int i=n-2;i>=0;i--) {
            if(arr.get(i) >= maxTillNow) {
                leaders.add(arr.get(i));
                maxTillNow = arr.get(i);
            }
        }
        Collections.reverse(leaders);
        return leaders;
    }
}
