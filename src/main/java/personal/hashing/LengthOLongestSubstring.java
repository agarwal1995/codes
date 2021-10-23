package personal.hashing;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class LengthOLongestSubstring {

    int longestUniqueSubsttr(String S){
        int max =Integer.MIN_VALUE;
        Set<Character> set = new HashSet<>();
        for(int i=0;i<S.length()-1;i++) {
            if(set.contains(S.charAt(i))) {
                max = Math.max(max, set.size());
                set.clear();
            }
            set.add(S.charAt(i));
        }
        return Math.max(max, set.size());
    }

    public static void main(String[] args) {
        System.out.println(new LengthOLongestSubstring().longestUniqueSubsttr("abcdhcbayr"));
    }
}
