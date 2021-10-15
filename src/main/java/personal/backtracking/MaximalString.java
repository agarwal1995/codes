package personal.backtracking;

import java.util.ArrayList;
import java.util.Collections;

public class MaximalString {

    static int max = 0;

    public String solve(String A, int B) {
        swapUtil(A, B, 0);
        return String.valueOf(max);
    }

    public void swapUtil(String str, int swap, int s) {
        int num = Integer.parseInt(str);

        for(int i=0;i<str.length();i++) {

        }
        max = Math.max(num, max);
        if(swap<1) {
            return;
        }

        for(int i=s+1;i<str.length();i++) {
            if (str.charAt(i) == str.charAt(s)) {
                continue;
            }
            String s1 = swap(str, i, s);
            swapUtil(s1, swap-1, s+1);
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
        MaximalString m = new MaximalString();
        System.out.println(m.solve("129814999",4));
    }
}
