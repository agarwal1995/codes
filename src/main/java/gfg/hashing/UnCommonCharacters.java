package gfg.hashing;

import java.util.Arrays;

/**
 * @author raag
 */
public class UnCommonCharacters {

    public static void main(String[] args) {
        new UnCommonCharacters().UncommonChars("geeksforgeeks","geeksquiz");
    }
    String UncommonChars(String A, String B) {
        int[] uncommon = new int[26];
        StringBuilder sbr = new StringBuilder();
        for(int i=0;i<A.length();i++) {
            uncommon[A.charAt(i)-97]=1;
        }
        for (int j=0;j<B.length();j++) {
            if(uncommon[B.charAt(j)-97]==1 || uncommon[B.charAt(j)-97]==2) {
                uncommon[B.charAt(j)-97]=2;
            } else {
                uncommon[B.charAt(j)-97]=3;
            }
        }
        for (int i=0;i<26;i++) {
            if(uncommon[i]==1 || uncommon[i]==3) {
                sbr.append((char) (i+97 ));
            }
        }
        String res = sbr.toString();
        char[] charRes = res.toCharArray();
        Arrays.sort(charRes);
        if(sbr.length()==0) {
            return "-1";
        }
        return new String(charRes);
    }
}
