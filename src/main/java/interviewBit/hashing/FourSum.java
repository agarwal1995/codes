package interviewBit.hashing;

import java.beans.IntrospectionException;
import java.util.*;

public class FourSum {

    public ArrayList<ArrayList<Integer>> fourSumWithN3(ArrayList<Integer> list, int B) {
        int n = list.size();
        ArrayList<ArrayList<Integer>> solution = new ArrayList<>();
        list.sort(Comparator.naturalOrder());
        for (int i=0;i<n-3;i++) {
            for (int j=i+1;j<n-2;j++) {
                int sum = list.get(i) + list.get(j);
                Set<Integer> set = new HashSet<>();
                for(int k=j+1;k<n;k++) {
                    if(set.contains(B-sum-list.get(k))) {
                        solution.add(new ArrayList<>(Arrays.asList(list.get(i), list.get(j), B-list.get(k)-sum, list.get(k))));
                    } else {
                        set.add(list.get(k));
                    }
                }
            }
        }
        return solution;
    }

    public ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> A, int B) {
        ArrayList<ArrayList<Integer>> solution = new ArrayList<>();

        int n = A.size();

        Map<Integer, Set<Pair>> sumToPairsSet = new HashMap<>();
        for(int i=0;i<n-1;i++) {
            for (int j=i+1;j<n;j++) {
                int sum = A.get(i) + A.get(j);
                sumToPairsSet.putIfAbsent(sum, new HashSet<>());
                sumToPairsSet.get(sum).add(new Pair(i, j));
            }
        }

        Set<Sol> sols = new HashSet<>();

        for(Map.Entry<Integer, Set<Pair>> mp : sumToPairsSet.entrySet()) {
            if(sumToPairsSet.containsKey(B - mp.getKey())) {
                Set<Pair> setPairs = sumToPairsSet.get(B- mp.getKey());
                for(Pair pair : setPairs) {
                    for(Pair pair1 : mp.getValue()) {
                        if(!pair.equals(pair1)) {
                            List<Integer> list = Arrays.asList(A.get(pair1.x),  A.get(pair1.y),  A.get(pair.x),  A.get(pair.y));
                            Collections.sort(list);
//                            if(checkForDifferent(list)) {
                                sols.add(new Sol(list.get(0), list.get(1), list.get(2), list.get(3)));
//                            }
                        }
                    }
                }
            }
        }

        for(Sol sol : sols) {
            solution.add(new ArrayList<>(Arrays.asList(sol.a, sol.b, sol.c, sol.d)));
        }
        solution.sort(new ListC());
        System.out.println(solution);
        return solution;
    }

    private boolean checkForDifferent(List<Integer> list) {
        if(list.get(0).compareTo(list.get(1))==0 || list.get(1).compareTo(list.get(2))==0 || list.get(2).compareTo(list.get(3))==0) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Integer[] array = {1, 0, -1, 0, -2, 2};
        List<Integer> list = Arrays.asList(array);
//        new FourSum().fourSum(new ArrayList<>(list), 0);
    }
}

class Sol {
    int a;
    int b;
    int c;
    int d;

    public Sol(int a, int b, int c, int d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    @Override
    public String toString() {
        return "Sol{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", d=" + d +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sol sol = (Sol) o;
        return a == sol.a &&
                b == sol.b &&
                c == sol.c &&
                d == sol.d;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c, d);
    }
}

class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return x==pair.x || x == pair.y || y==pair.x || y==pair.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}


class ListC implements Comparator<ArrayList<Integer>> {

    @Override
    public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
        if(o1.get(0).compareTo(o2.get(0))!=0) {
            return o1.get(0).compareTo(o2.get(0));
        }
        if(o1.get(1).compareTo(o2.get(1))!=0) {
            return o1.get(1).compareTo(o2.get(1));
        }
        if(o1.get(2).compareTo(o2.get(2))!=0) {
            return o1.get(2).compareTo(o2.get(2));
        }
        return o1.get(3).compareTo(o2.get(3));
    }
}