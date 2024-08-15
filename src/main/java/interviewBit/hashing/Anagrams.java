package interviewBit.hashing;

import java.util.*;

/**
 * @author raag
 */
public class Anagrams {

    public static void main(String[] args) {
        new Anagrams().anagrams(Arrays.asList("cat","dog","god","tca"));
    }

    public ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {

        Map<String, List<Integer>> map = new LinkedHashMap<>();

        int i=0;
        for (String s: A) {
            String sortedS = s.chars()
                    .sorted()
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();

            map.putIfAbsent(sortedS, new ArrayList<>());
            map.get(sortedS).add(++i);
        }
        ArrayList<ArrayList<Integer>> sol = new ArrayList<>();
        for (Map.Entry<String, List<Integer>> mv : map.entrySet()) {
            sol.add(new ArrayList<>(mv.getValue()));
        }
        System.out.println(sol);
        return sol;
    }
}
