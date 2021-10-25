package personal.hashing;

import java.util.*;

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

    public int lengthOfLongestSubstring(String A) {
        int n = A.length();
        int i = 0, j=0;

        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        while (i<n && j<n) {
            char charJ = A.charAt(j);
            if (map.containsKey(charJ)) {
                while (i <= j) {
                    char charI = A.charAt(i);
                    map.remove(charI);
                    i++;
                    if (charI == charJ) {
                        break;
                    }
                }
            } else {
                map.put(charJ, 1);
                j++;
            }
            max = Math.max(max, j-i);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new LengthOLongestSubstring().lengthOfLongestSubstring("abcabcbb"));
    }
}
