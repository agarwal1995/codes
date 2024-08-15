package interviewBit.backtracking;

import java.util.Arrays;

/**
 * @author raag
 */
public class MaximalString {

    public static void main(String[] args) {
        System.out.println(new MaximalString().solve("254",1));
        System.out.println(new MaximalString().solve("254",2));
        System.out.println(new MaximalString().solve("129814999",4));
    }


    private String max;

    public String solve(String A, int B) {
        max = new String(A);
        rec(new StringBuilder(A), B);
        return max;
    }

    private void rec(StringBuilder a,int k) {
        if (k<=0) {
            return;
        }
        for (int i=0;i<a.length();i++) {
            for (int j=i+1;j<a.length();j++) {
                if (a.charAt(j)>a.charAt(i)) {
                    swap(a, i, j);
                    if (max.compareTo(a.toString()) < 0) {
                        max = new String(a.toString());
                    }
                    rec(a, k-1);
                    swap(a, i, j);
                }
            }
        }
    }
    private void swap(StringBuilder input, int x, int y) {
        if (x==y) {
            return;
        }
        char temp = input.charAt(x);
        input.setCharAt(x, input.charAt(y));
        input.setCharAt(y, temp);
    }

//    public String solve(String A, int B) {
//        int[] input = new int[A.length()];
//        int i=0;
//        for (char ch: A.toCharArray()) {
//            input[i] = (int) ch-'0';
//            i++;
//        }
//
//        int s = 0;
//        while (B>0 && s<A.length()) {
//            int x = findMaxNumberIndex(input, s);
//            if (input[x]==input[s]) {
//                s++;
//                continue;
//            }
//            swap(input, x, s);
//            s++;
//            B--;
//        }
//        StringBuilder sbr = new StringBuilder();
//        for (int x:input) {
//            sbr.append(x);
//        }
//        return sbr.toString();
//    }

    //    private int findMaxNumberIndex(int[] input, int s) {
//        int mI = s;
//        for (int i=s;i<input.length;i++) {
//            mI = input[i]>=input[mI]?i:mI;
//        }
//        if (mI==s) {
//            return -1;
//        }
//        return mI;
//    }


//    private void solve(int[] inp, long num) {
//
//    }
}
