package interviewBit.hashing;

import java.util.*;

/**
 * @author raag
 */
public class SubstringConcatenation {

    public static void main(String[] args) {
        System.out.println(new SubstringConcatenation().findSubstring("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                new ArrayList<>(Arrays.asList("aaa", "aaa", "aaa", "aaa", "aaa"))));
    }

    public ArrayList<Integer> findSubstring(String A, final List<String> B) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : B) {
            map.putIfAbsent(s, 0);
            map.put(s, map.get(s) + 1);
        }

        int n = A.length();

        int l = B.get(0).length();

        ArrayList<Integer> result = new ArrayList<>();

        for (int i=0;i<=n-l;i++) {
            Map<String, Integer> clonedMap = new HashMap<>(map);

            int j=i, count = B.size();
            while (j<=n-l) {
                String sbr = A.substring(j, j+l);
                if (clonedMap.containsKey(sbr) && clonedMap.get(sbr)>0) {
                    clonedMap.put(sbr, clonedMap.get(sbr)-1);
                    count--;
                    j = j + l;
                } else {
                    break;
                }
            }

            if (count==0) {
                result.add(i);
            }
        }
        return result;
    }
}
