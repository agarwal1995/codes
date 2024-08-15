package interviewBit.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author raag
 */
public class AllPossibleCombinations {

    public static void main(String[] args) {
        new AllPossibleCombinations().specialStrings(new ArrayList<>(Arrays.asList("ab","cd")));
        new AllPossibleCombinations().specialStrings(new ArrayList<>(Arrays.asList("aa","bb")));
        new AllPossibleCombinations().specialStrings(new ArrayList<>(Arrays.asList("ab","ac","ad")));
        new AllPossibleCombinations().specialStrings(new ArrayList<>(Arrays.asList("abc", "def")));
    }

    public ArrayList<String> specialStrings(ArrayList<String> A) {
        // sort all string
        List<String> sortedString = new ArrayList<>();
        for (String s : A) {
            char[] tempArray = s.toCharArray();
            Arrays.sort(tempArray);
            sortedString.add(new String(tempArray));
        }

        ArrayList<String> solutions = new ArrayList<>();
        specialString(sortedString, solutions, 0,0,sortedString.size(), new StringBuilder());
        return solutions;
    }

    public void specialString(List<String> sortedString, ArrayList<String> specialString,
                              int i, int j, int n, StringBuilder currentString) {
        if (i>=n) {
            return;
        }
        for (int k=i;k<n;k++) {
            for (int l=0;l<sortedString.get(k).length();l++) {
                currentString.append(sortedString.get(k).charAt(l));
                specialString(sortedString, specialString, k+1, j, n, currentString);
                if (currentString.length()==sortedString.size()) {
                    specialString.add(currentString.toString());
                }
                currentString.deleteCharAt(currentString.length()-1);
            }
        }
    }
}
