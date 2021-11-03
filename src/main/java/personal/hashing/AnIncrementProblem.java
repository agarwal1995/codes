//package personal.hashing;
//
//import java.util.*;
//
//public class AnIncrementProblem {
//
//    public ArrayList<Integer> solve(ArrayList<Integer> A) {
//        Map<Integer, Integer> map = new TreeMap<>();
//        Set<Integer> set = new HashSet<>();
//        for(int x:A) {
//            if (set.contains(x)) {
//                set.remove(x);
//            }
//            if (map.containsKey(x)) {
//                map.putIfAbsent(x);
//                map.remove(x);
//            }
//            map.putIfAbsent(x, 0);
//        }
//    }
//
//    public static void main(String[] args) throws Exception {
//
//    }
//}
