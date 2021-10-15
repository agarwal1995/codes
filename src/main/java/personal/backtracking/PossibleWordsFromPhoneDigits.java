package personal.backtracking;

import java.util.*;

public class PossibleWordsFromPhoneDigits {

    private static Map<Integer, List<Character>> map = new HashMap<>();

    static {
        map.put(2, Arrays.asList('a','b','c'));
        map.put(3, Arrays.asList('d','e','f'));
        map.put(4, Arrays.asList('g','h','i'));
        map.put(5, Arrays.asList('j','k','l'));
        map.put(6, Arrays.asList('m','n','o'));
        map.put(7, Arrays.asList('p','q','r','s'));
        map.put(8, Arrays.asList('t','u','v'));
        map.put(9, Arrays.asList('w','x','y','z'));
    }

    public void phoneDigits(int[] array, int n) {

    }

    public static void phoneUtil(String array, int keyIndex, StringBuilder sbr, List<String> sol) {
        if(keyIndex >= array.length()) {
            return;
        }
        int val = Integer.parseInt(String.valueOf(array.charAt(keyIndex)));
        for(int j=0;j<map.get(val).size(); j++) {
            sbr.append(map.get(val).get(j));
            if (sbr.length() == array.length()) {
                sol.add(new String(sbr));
            } else {
                phoneUtil(array, keyIndex+1, sbr, sol);
            }
            sbr.deleteCharAt(sbr.length()-1);
        }
    }

    public static ArrayList<String> possibleWords(String A, int N) {
        ArrayList<String> sol = new ArrayList<>();
        StringBuilder stringBuilder =  new StringBuilder();
        phoneUtil(A, 0, stringBuilder, sol);
        return sol;
    }

    public static void main(String[] args) {
        int n = 2;
        int[] array = {2,3,4};

        possibleWords("234", n);
    }
}
