package leetcode.studyplan.datastructure.first;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqueString {
    public int firstUniqChar(String s) {
        Map<Character,Integer> map = new LinkedHashMap<>();
        int n = s.length();
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            if(map.containsKey(ch)) {
                map.put(ch, n);
            } else {
                map.put(ch, i);
            }
        }
        for(Map.Entry<Character, Integer> mp : map.entrySet()) {
            if(mp.getValue()!=n) {
                return mp.getValue();
            }
        }
        return -1;
    }
}
