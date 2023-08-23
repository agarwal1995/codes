package gfg.hashing;

/**
 * @author raag
 */
public class MinimumIndexedCharacter {
    public static int minIndexChar(String str, String patt) {
        int[] freq = new int[26];
        for(int i=0;i<patt.length();i++) {
            freq[patt.charAt(i)-97]++;
        }
        for (int i=0;i<str.length();i++) {
            if(freq[str.charAt(i)-97]!=0) {
                return i;
            }
        }
        return -1;
    }
}
