package interviewBit.backtracking;

import java.util.*;

/**
 * @author raag
 */
public class LetterPhone {

    public static void main(String[] args) {
        System.out.println(new LetterPhone().letterCombinations("23"));
        System.out.println(new LetterPhone().letterCombinations("012"));
    }

    Map<Integer, List<Character>> digitMap = new HashMap<>();

    ArrayList<String> result = new ArrayList<>();

    private void initializeMap() {
        digitMap.put(0, Collections.singletonList('0'));
        digitMap.put(1, Collections.singletonList('1'));
        digitMap.put(2, Arrays.asList('a','b','c'));
        digitMap.put(3, Arrays.asList('d','e','f'));
        digitMap.put(4, Arrays.asList('g','h','i'));
        digitMap.put(5, Arrays.asList('j','k','l'));
        digitMap.put(6, Arrays.asList('m','n','o'));
        digitMap.put(7, Arrays.asList('p','q','r','s'));
        digitMap.put(8, Arrays.asList('t','u','v'));
        digitMap.put(9, Arrays.asList('w','x','y','z'));
    }

    public ArrayList<String> letterCombinations(String A) {
        initializeMap();

        int[] array = new int[A.length()];
        for (int i=0;i<A.length();i++) {
            array[i] = Integer.parseInt(String.valueOf(A.charAt(i)));
        }
        rec(array, 0, A.length(), new StringBuilder());
        return result;
    }

    private void rec(int[] array, int start, int n, StringBuilder sbr) {
        if (start==n) {
            result.add(new String(sbr));
            return;
        }
        for (Character ch : digitMap.get(array[start])) {
            sbr.append(ch);
            rec(array, start+1, n, sbr);
            sbr.deleteCharAt(sbr.length()-1);
        }
    }
}
