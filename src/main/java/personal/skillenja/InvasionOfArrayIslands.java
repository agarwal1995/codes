package personal.skillenja;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InvasionOfArrayIslands {

    static List<String> anagrams(String str) {
        List<String> sol = new ArrayList<>();
        anagramUtil(sol, new StringBuilder(str), 0, str.length());
        Collections.sort(sol);
        return sol;
    }

    static void anagramUtil(List<String> solutions, StringBuilder sbr, int s, int n) {
        if(s==n-1) {
            solutions.add(new String(sbr));
            return;
        }
        for(int i = s;i<n;i++) {
            swap(sbr, i, s);
            anagramUtil(solutions, sbr, s+1, n);
            swap(sbr, i, s);
        }
    }

    static void swap(StringBuilder sbr, int i, int j) {
        char ch = sbr.charAt(i);
        sbr.setCharAt(i, sbr.charAt(j));
        sbr.setCharAt(j, ch);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t>0) {
            String str = br.readLine().trim();
            List<String> sol = anagrams(str);
            for (String s : sol) {
                System.out.print(s +" ");
            }
            System.out.println();
            t--;
        }
    }
}
