package gfg.hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author raag
 */
public class CheckIfTwoArraysAreEqual {

    public static void main(String[] args) {
        check(new long[] {16 ,1 ,2 ,14 ,13 ,17, 1}
                ,new long[] {14, 1, 16, 2, 13, 2, 17},7);
    }
    public static boolean check(long A[],long B[],int N) {
        Map<Long, Integer> mapA = new HashMap<>();
        Map<Long, Integer> mapB = new HashMap<>();
        for(long x:A) {
            mapA.putIfAbsent(x, 0);
            mapA.put(x, mapA.get(x)+1);
        }
        for(long x:B) {
            mapB.putIfAbsent(x, 0);
            mapB.put(x, mapB.get(x)+1);
        }
        if(mapB.size()!=mapA.size()) {
            return false;
        }
        for(Map.Entry<Long, Integer> entry: mapA.entrySet()) {
            if(mapB.containsKey(entry.getKey()) && mapB.get(entry.getKey()).compareTo(entry.getValue())==0) {
                continue;
            }
            return false;
        }
        return true;
    }
}
