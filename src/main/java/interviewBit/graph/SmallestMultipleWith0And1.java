package interviewBit.graph;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author raag
 */
public class SmallestMultipleWith0And1 {

    public static void main(String[] args) {
        System.out.println(new SmallestMultipleWith0And1().multiple(55));
        System.out.println(new SmallestMultipleWith0And1().multiple(999));
        System.out.println(new SmallestMultipleWith0And1().multiple(3));
        System.out.println(new SmallestMultipleWith0And1().multiple(2));
        System.out.println(new SmallestMultipleWith0And1().multiple(95337));
        System.out.println(new SmallestMultipleWith0And1().multiple(66924));
    }

//    public String multiple(int A) {
//        if (A==0) {
//            return "0";
//        }
//
//        Queue<BigDecimal> queue = new LinkedList<>();
//        queue.add(BigDecimal.valueOf(1));
//
//        Set<BigDecimal> set = new HashSet<>();
//
//        BigDecimal multiplier10 = new BigDecimal(10);
//        BigDecimal value1 = new BigDecimal(1);
//        BigDecimal valueA = new BigDecimal(A);
//        while (!queue.isEmpty()) {
//            BigDecimal val = queue.poll();
//
//            BigDecimal remainder = val.remainder(valueA);
//
//            if (BigDecimal.ZERO.compareTo(remainder) == 0) {
//                return val.toString();
//            }
//            BigDecimal with0 = val.multiply(multiplier10);
//            BigDecimal with1 = (val.multiply(multiplier10)).add(value1);
//
//            if (!set.contains(remainder)) {
//                queue.add(with0);
//                queue.add(with1);
//                set.add(remainder);
//            }
//
//        }
//        return "-1";
//
//    }

    public String multiple(int A) {
        if (A==0) {
            return "0";
        }

        Queue<String> queue = new LinkedList<>();
        queue.add("1");

        Set<Integer> set = new HashSet<>();

        while (!queue.isEmpty()) {

            String val = queue.poll();

            int remainder = mod(val, A);

            if (remainder==0) {
                return val;
            }

            if (!set.contains(remainder)) {
                String with1 = val + "1";
                String with0 = val + "0";
                queue.add(with0);
                queue.add(with1);
                set.add(remainder);
            }

        }
        return "-1";

    }

    private int mod(String s, int A) {
        int r = 0;
        for (int i=0;i<s.length();i++) {
            r = r*10 + (s.charAt(i)-'0');
            r = r%A;
        }
        return r;
    }
}
