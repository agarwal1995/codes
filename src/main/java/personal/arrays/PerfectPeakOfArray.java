package personal.arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PerfectPeakOfArray {

    public int perfectPeak(ArrayList<Integer> list) {
        int n = list.size();
        int[] maxFromLeftSide = new int[n];
        int[] minFromRightSide = new int[n];

        maxFromLeftSide[0] = list.get(0);
        minFromRightSide[n-1] = list.get(n-1);
        int j = n-2;
        for (int i=1;i<n-1;i++) {
            maxFromLeftSide[i] = Math.max(maxFromLeftSide[i-1], list.get(i));
            minFromRightSide[j] = Math.min(minFromRightSide[j+1], list.get(j));
            j--;
        }

        for(int i=1;i<n-1;i++) {
            if (list.get(i) > maxFromLeftSide[i-1] && list.get(i) < minFromRightSide[i+1]) {
                return 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().trim().split("\\s+");

        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<line.length;i++) {
            list.add(Integer.parseInt(line[i]));
        }
        System.out.println(new PerfectPeakOfArray().perfectPeak(list));
    }
}
