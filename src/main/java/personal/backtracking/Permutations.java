package personal.backtracking;

import java.util.ArrayList;
import java.util.Collections;

public class Permutations {

    public ArrayList<String> permutation(String S)
    {
        int n=S.length();

        ArrayList<String> str = new ArrayList<>();

        permutationUtil(0, n-1, S, str);
        Collections.sort(str);
        System.out.println(str);
        return str;
    }

    public void permutationUtil(int start, int end, String s, ArrayList<String> sol) {
        if(start == end) {
            sol.add(s);
            return ;
        }
        for(int i=start; i<=end; i++) {
            String s1 = swap(s, i, start);
            permutationUtil(start+1, end, s1, sol);
        }
    }

    public String swap(String s, int i, int j) {
        StringBuilder sbr = new StringBuilder(s);
        char ch = s.charAt(j);
        sbr.setCharAt(j, s.charAt(i));
        sbr.setCharAt(i, ch);
        return sbr.toString();
    }

    public static void main(String[] args) {
        Permutations p = new Permutations();
        p.permutation("ABSG");
    }
}
