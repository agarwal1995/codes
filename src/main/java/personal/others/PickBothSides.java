package personal.others;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PickBothSides {

    public static int solve(ArrayList<Integer> A, int B) {
        int n = A.size();
        int maxSum = 0;
        int sumStart = 0;
        int sumEnd = 0;

        for(int i=0;i<B;i++) {
            sumStart = sumStart + A.get(i);
        }

        maxSum = sumStart;
        int k=n-1;
        for(int i=0;i<B;i++) {
            sumStart = sumStart - A.get(B-i-1) + A.get(k);
            k--;
            maxSum = Math.max(maxSum, sumStart);
        }
        return maxSum;


    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().trim().split("\\s+");
        int n = line.length;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=0;i<line.length;i++) {
            list.add(Integer.parseInt(line[i]));
        }
        int b = Integer.parseInt(br.readLine().trim());
        System.out.println(solve(list, b));
    }
}
