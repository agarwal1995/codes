package interviewBit.hashing;

import java.util.HashMap;
import java.util.Map;

public class WindowString {

    public String minWindow(String first, String second) {
        int i = 0;
        int j = 0;
        Map<Character, Integer> secondMap = new HashMap<>();
        for (int k =0; k<second.length(); k++) {
            secondMap.putIfAbsent(second.charAt(k), 0);
            secondMap.put(second.charAt(k), secondMap.get(second.charAt(k)) +1);
        }

        int n = first.length();
        Map<Character, Integer> firstCount = new HashMap<>();
        int totalCount = 0;
        int secondLength = second.length();

        int fIndex = -1;
        int secondInd = -1;

        int minLength = Integer.MAX_VALUE;
        while(i<n && j<n) {
            char ch = first.charAt(j);
            if(secondMap.containsKey(ch)) {
                firstCount.putIfAbsent(ch, 0);
                firstCount.put(ch, firstCount.get(ch)+1);
                while (i<j) {
                    char ch1 = first.charAt(i);
                    if (!secondMap.containsKey(ch1)) {
                        i++;
                    } else  if((secondMap.containsKey(ch1) && firstCount.containsKey(ch1) && firstCount.get(ch1).compareTo(secondMap.get(ch1)) >0)) {
                        firstCount.put(ch1, firstCount.get(ch1)-1);
                        i++;
                    } else {
                        break;
                    }
                }
            }
            if(checkMatch(secondMap, firstCount) ) {
//                System.out.println(first.substring(i, j+1));
                if(minLength > j-i+1) {
                    minLength = j-i+1;
                    fIndex = i;
                    secondInd = j;
                }
            }
            j++;
        }
        if(fIndex==-1) {
            return "";
        }
        return first.substring(fIndex, secondInd+1);
    }

    private boolean checkMatch(Map<Character, Integer> secondMap, Map<Character, Integer> firstMap) {
        for (Map.Entry<Character, Integer> mp : secondMap.entrySet()) {
            if(!(firstMap.containsKey(mp.getKey()) && firstMap.get(mp.getKey()) >=mp.getValue())) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        long  j = System.currentTimeMillis();
        System.out.println(new WindowString().minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(System.currentTimeMillis()-j);
    }
}
