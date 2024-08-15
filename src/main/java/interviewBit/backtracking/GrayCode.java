package interviewBit.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author raag
 */
public class GrayCode {

    public static void main(String[] args) {
        new GrayCode().grayCode(3);
    }

    public ArrayList<Integer> grayCode(int A) {
        StringBuilder sbr = new StringBuilder();

        if (A==1) {
            return new ArrayList<>(Arrays.asList(0,1));
        }
        for (int i=1;i<=A;i++ ) {
            sbr.append("0");
        }

        ArrayList<StringBuilder> result = new ArrayList<>();
        result.add(sbr);
        for (int i=1;i<=A;i++) {
            ArrayList<StringBuilder> list = new ArrayList<>();
            for (int j=result.size()-1;j>=0;j--) {
                StringBuilder sbr2 = new StringBuilder(result.get(j));
                sbr2.setCharAt(sbr.length()-i, '1');
                list.add(sbr2);
            }
            result.addAll(list);
        }
//        return result.stream().map(StringBuilder::toString).map(x -> Integer.parseInt(x, 2)).collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Integer> res = new ArrayList<>();
        for (StringBuilder sb:result){
            res.add(Integer.parseInt(sb.toString(), 2));
        }
        return res;

    }

    private void rec(StringBuilder sbr, ArrayList<Integer> sol, int x) {
        if (x==sbr.length()) {
            sol.add(Integer.parseInt(sbr.toString(), 2));
            return;
        }


    }

}
