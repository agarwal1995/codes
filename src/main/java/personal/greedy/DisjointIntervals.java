package personal.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DisjointIntervals {

    public int solve(ArrayList<ArrayList<Integer>> A) {
        A.sort((a, b) -> a.get(1).compareTo(b.get(1)));
        System.out.println(A);
        int count = 1;
        int lastVal = A.get(0).get(1);
        for(int i=1;i<A.size();i++) {
            if (A.get(i).get(0) > lastVal) {
                count++;
                lastVal = A.get(i).get(1);
            }
        }
        return count;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0;i<4;i++) {
            ArrayList<Integer> list1 = new ArrayList<>();
            String[] line = br.readLine().trim().split("\\s+");
            list1.add(Integer.parseInt(line[0]));
            list1.add(Integer.parseInt(line[1]));
            list.add(list1);
        }
        System.out.println(new DisjointIntervals().solve(list));
    }
}
