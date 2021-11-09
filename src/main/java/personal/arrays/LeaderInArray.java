package personal.arrays;

import java.util.ArrayList;
import java.util.Collections;

public class LeaderInArray {

    public ArrayList<Integer> solve(ArrayList<Integer> arr) {
        int n = arr.size();
        ArrayList<Integer> leaders = new ArrayList<>();
        leaders.add(arr.get(n-1));
        int maxTillNow = arr.get(n-1);
        for(int i=n-2;i>=0;i--) {
            if(arr.get(i) > maxTillNow) {
                leaders.add(arr.get(i));
                maxTillNow = arr.get(i);
            }
        }
        Collections.reverse(leaders);
        return leaders;
    }
}
