package interviewBit.arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SortArrayWithSquares {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().trim().split("\\s+");
        ArrayList<Integer> list = new ArrayList<>();
        for (String s: line) {
            list.add(Integer.parseInt(s));
        }
        System.out.println(new SortArrayWithSquares().solve(list));
    }


    public ArrayList<Integer> solve(ArrayList<Integer> list) {
        int x = findFirstPositive(list);
        int y = x-1;
        int n = list.size();
        ArrayList<Integer> result = new ArrayList<>();
        while (x<n && y>=0) {
            int a = list.get(x) * list.get(x);
            int b = list.get(y) * list.get(y);
            if(a<=b) {
                x++;
                result.add(a);
            } else {
                y--;
                result.add(b);
            }
        }
        while (x<n) {
            result.add(list.get(x)*list.get(x));
            x++;
        }
        while (y>=0) {
            result.add(list.get(y)*list.get(y));
            y--;
        }
        return result;
    }

    public int findFirstPositive(ArrayList<Integer> list) {
        int l = 0, r = list.size()-1;
        if(list.get(l)>=0) {
            return 0;
        }
        while (l<=r) {
            int mid = l + (r-l)/2;
            if(mid>0 && list.get(mid) >=0 && list.get(mid-1) <0) {
                return mid;
            } else if(list.get(mid)>=0) {
                r = mid-1;
            } else {
                l = mid+1;
            }
        }
        return list.size();
    }
}
