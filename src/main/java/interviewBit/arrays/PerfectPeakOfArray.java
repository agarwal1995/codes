package interviewBit.arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class PerfectPeakOfArray {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().trim().split("\\s+");

        ArrayList<Integer> list = new ArrayList<>();
        for(String s : line) {
            list.add(Integer.parseInt(s));
        }
        System.out.println(new PerfectPeakOfArray().perfectPeak(list));
    }
    public int perfectPeak(ArrayList<Integer> A) {
        ArrayList<Integer> left = new ArrayList<>();
        left.add(A.get(0));
        for(int i=1;i<A.size();i++) {
            left.add(Math.max(A.get(i), left.get(i-1)));
        }
        int n=A.size();
        int min = A.get(n-1);
        System.out.println(left);
        for (int j=n-2;j>0;j--) {
            if(A.get(j) < min && A.get(j)> left.get(j-1)) {
                return 1;
            }
            min = Math.min(min, A.get(j));
        }
        return 0;
    }
}
