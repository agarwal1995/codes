package leetcode.studyplan.datastructure.first;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {public boolean isAnagram(String s, String t) {
    Map<Character, Integer> tFreq = new HashMap<>();
    for(int i=0;i<t.length();i++) {
        char ch1 = t.charAt(i);
        tFreq.putIfAbsent(ch1, 0);
        tFreq.put(ch1, tFreq.get(ch1)+1);
    }
    for(int i=0;i<s.length();i++) {
        char ch = s.charAt(i);
        if(!tFreq.containsKey(ch) || tFreq.get(ch)<=0) {
            return false;
        }
        tFreq.put(ch,tFreq.get(ch)-1) ;
    }
    for(Map.Entry<Character,Integer> mp: tFreq.entrySet()) {
        if(mp.getValue()>0) {
            return false;
        }
    }
    return true;
}

}
