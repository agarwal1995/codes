package interviewBit.hashing;

import java.util.*;

/**
 * @author raag
 */
public class Equal {

    public static void main(String[] args) {
        System.out.println(new Equal().equal(new ArrayList<>(Arrays.asList(2,5,1,6))));
        System.out.println(new Equal().equal(new ArrayList<>(Arrays.asList(3,4,7,1,2,9,8))));
    }

    public ArrayList<Integer> equal(ArrayList<Integer> A) {
        Map<Integer, Pair3> map = new LinkedHashMap<>();

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int n = A.size();
        for (int i=0;i<n;i++) {
            for (int j=i+1;j<n;j++) {
                int s = A.get(i) + A.get(j);
                if (map.containsKey(s) && !(map.get(s).x==i || map.get(s).x==j || map.get(s).y==i || map.get(s).y==j) && map.get(s).x < i && map.get(s).y<j) {
                    list.add(new ArrayList<>(Arrays.asList(map.get(s).x, map.get(s).y, i, j)));
                }
                map.putIfAbsent(s, new Pair3(i,j));
            }
        }
        Collections.sort(list, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> list, ArrayList<Integer> t1) {
                for (int i=0;i<4;i++) {
                    if (list.get(i).compareTo(t1.get(i)) == 0) {
                        continue;
                    }
                    return list.get(i).compareTo(t1.get(i));
                }
                return 0;
            }
        });
        if (list.isEmpty()) {
            return new ArrayList<>();
        }
        return list.get(0);
     }
}

class Pair3 {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair3 pair3 = (Pair3) o;
        return x == pair3.x && y == pair3.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public Pair3(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Pair3{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    int x;
    int y;

}
