package gfg.hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * @author raag
 */
public class FirstElementKTimes {
    public int firstElementKTime(int[] a, int n, int k) {
        Map<Integer, Integer>  map = new HashMap<>();
        for(int x: a) {
            map.putIfAbsent(x, 0);
            map.put(x, map.get(x)+1);
            if(map.get(x)==k){
                return x;
            }
        }
        return -1;
    }
}
