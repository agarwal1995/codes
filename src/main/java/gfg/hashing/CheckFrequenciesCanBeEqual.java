package gfg.hashing;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author raag
 */
public class CheckFrequenciesCanBeEqual {

    public static void main(String[] args) {

    }

    boolean sameFreq(String s) {
        int[] freqArray = new int[26];
        int n = s.length();
        for(int i=0;i<n;i++) {
            freqArray[s.charAt(i)-97]++;
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i=0;i<26;i++) {
            map.putIfAbsent(freqArray[i], 0);
            map.put(freqArray[i], map.get(freqArray[i])+1);
        }
        map.remove(0);
        if(map.size()==1 || map.size()==2 && map.lastKey()-map.firstKey()==1 && map.lastEntry().getValue()==1 || map.size()==2 && map.firstKey()==1 && map.firstEntry().getValue()==1){
            return true;
        }
        return false;
    }
}
