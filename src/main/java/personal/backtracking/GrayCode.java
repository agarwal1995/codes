package personal.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GrayCode {
    public ArrayList<Integer> grayCode(int a) {
        List<String> list = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        list =grayCodeUtil(a, new ArrayList<>());
        list.forEach(l-> {
            System.out.println(l);
            list1.add(Integer.parseInt(l, 2));
        });
        return list1;
    }

    public List<String> grayCodeUtil(int a, ArrayList<Integer> sol) {
        if (a==1) {
            List<String> list = new ArrayList<>();
            list.add("0");
            list.add("1");
            return list;
        }
        List<String> strings1 = new ArrayList<>();
        List<String> strings = grayCodeUtil(a-1, sol);
        for(String s : strings) {
            strings1.add("0" + s);
        }
        Collections.reverse(strings);
        for(String s : strings) {
            strings1.add("1" + s);
        }
        return strings1;
    }

    public static void main(String[] args) {
        GrayCode grayCode = new GrayCode();
        System.out.println(grayCode.grayCode(10));
    }
}
