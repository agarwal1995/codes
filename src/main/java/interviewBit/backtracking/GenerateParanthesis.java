package interviewBit.backtracking;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author raag
 */
public class GenerateParanthesis {

    public static void main(String[] args) {
        new GenerateParanthesis().generateParenthesis(3);
    }

    private ArrayList<String> result = new ArrayList<>();

    public ArrayList<String> generateParenthesis(int A) {
        generate(A,A, new StringBuilder());
        return result;
    }

    private void generate(int openBrackets, int closedBrackets,
                          StringBuilder sbr) {
        if (openBrackets==0 && closedBrackets==0) {
            result.add(new String(sbr));
        }
        if (openBrackets>closedBrackets) {
            return;
        }
        if (closedBrackets<=0 || openBrackets<0) {
            return;
        }

        sbr.append("(");
        generate(openBrackets-1, closedBrackets, sbr);
        sbr.setLength(sbr.length()-1);

        sbr.append(")");
        generate(openBrackets, closedBrackets-1, sbr);
        sbr.setLength(sbr.length()-1);
    }
}
