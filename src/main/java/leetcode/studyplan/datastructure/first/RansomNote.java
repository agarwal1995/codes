package leetcode.studyplan.datastructure.first;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> magFreq = new HashMap<>();
        for(int i=0;i<magazine.length();i++) {
            char ch1 = magazine.charAt(i);
            magFreq.putIfAbsent(ch1, 0);
            magFreq.put(ch1, magFreq.get(ch1)+1);
        }
        for(int i=0;i<ransomNote.length();i++) {
            char ch = ransomNote.charAt(i);
            if(!magFreq.containsKey(ch) || magFreq.get(ch)<=0) {
                return false;
            }
            magFreq.put(ch,magFreq.get(ch)-1) ;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new RansomNote().canConstruct("a", "b"));
    }
}
