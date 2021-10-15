package personal.backtracking;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public List<String> AllParenthesis(int n) {
        StringBuilder sbr = new StringBuilder();
        List<String> sol = new ArrayList<>();
        parenthesisUtil(0,0,0,sol, sbr, n);
        return sol;
    }

    public void parenthesisUtil(int openTillNow, int totalOpen, int index, List<String> sol, StringBuilder sbr, int n) {
        if(sbr.length() == n*2) {
            sol.add(sbr.toString());
            return;
        }
        if (totalOpen <n) {
            sbr.append("(");
            parenthesisUtil(openTillNow +1, totalOpen+1,index +1, sol, sbr, n);
            sbr.deleteCharAt(sbr.length()-1);
        }
        if (openTillNow>0) {
            sbr.append(")");
            parenthesisUtil(openTillNow -1, totalOpen , index+1, sol, sbr, n);
            sbr.deleteCharAt(sbr.length()-1);
        }
    }

    public static void main(String[] args) {
        GenerateParentheses generateParentheses = new GenerateParentheses();
        int arr[] = {1,2,3,4,5};

        for(int i = 0 ; i<5; i++){
            System.out.print(arr[i++]);
        }
//        System.out.println(generateParentheses.AllParenthesis(3));
    }

    class A {
        void m() throws IOException, Exception {

        }
    }

    class B extends A {
        @Override
        void m() throws Exception {
            super.m();
        }
    }
}
