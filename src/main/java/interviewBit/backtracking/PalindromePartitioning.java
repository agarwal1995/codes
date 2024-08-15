package interviewBit.backtracking;

import java.util.ArrayList;

/**
 * @author raag
 */
public class PalindromePartitioning {

    public static void main(String[] args) {
        System.out.println(new PalindromePartitioning().partition("aab"));
        System.out.println(new PalindromePartitioning().partition("efe"));
    }

    public ArrayList<ArrayList<String>> result = new ArrayList<>();
    public ArrayList<ArrayList<String>> partition(String a) {
        rec(a, 0, a.length(), new ArrayList<>());
        return result;
    }

    private void rec(String a, int start, int n, ArrayList<String> currentString) {
        if (start==n) {
            result.add(new ArrayList<>(currentString));
        }

        for (int i=start;i<n;i++) {
            String s = a.substring(start, i+1);
            if (!checkPalindrome(s)) {
                continue;
            }
            currentString.add(s);
            rec(a, i+1, n, currentString);
            currentString.remove(currentString.size()-1);
        }
    }

    private boolean checkPalindrome(String s) {
        for(int i=0,j=s.length()-1;i<=j;i++,j--) {
            if (s.charAt(i)!=s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
