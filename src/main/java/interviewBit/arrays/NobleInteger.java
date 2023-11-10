package interviewBit.arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class NobleInteger {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().trim().split("\\s+");
        ArrayList<Integer> list = new ArrayList<>();
        for (String s: line) {
            list.add(Integer.parseInt(s));
        }
        System.out.println(new NobleInteger().solve(list));
    }

    public int solve(ArrayList<Integer> list) {
        Collections.sort(list);
        int n = list.size();
        for (int i=0;i<n;i++) {
            if((i<n-1 && list.get(i).compareTo(list.get(i+1))!=0) || i==n-1) {
                if(list.get(i) == n - i -1) {
                    return 1;
                }
            }
        }
        return -1;
    }
}
