package interviewBit.arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Partitions {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().trim().split("\\s+");
        ArrayList<Integer> list = new ArrayList<>();
        for(String s:line) {
            list.add(Integer.parseInt(s));
        }
        System.out.println(new Partitions().solve(list.size(), list));
    }

    public int solve(int A, ArrayList<Integer> B) {

        int sum = 0;
        for(int x:B) {
            sum = sum+x;
        }
        if(sum%3!=0) {
            return -1;
        }

        int i=0;
        int xSum = 0;
        for (i=0;i<A;i++) {
            xSum += B.get(i);
            if(xSum>(sum/3)) {
                return -1;
            }
            if(xSum == (sum/3)) {
                break;
            }
        }

        int j = A-1;
        int ySum = 0;
        for (j=A-1;j>i+1;j--) {
            ySum += B.get(j);
            if(ySum>(sum/3)) {
                return -1;
            }
            if(ySum == (sum/3)) {
                break;
            }
        }
        int rZero = 0;
        for (j=j;j>i+1;j--) {
            if(B.get(j)==0) {
                rZero++;
            }
        }
        int lZero = 0;
        int k = i;
        while (true) {
            if(B.get(++k)==0) {
                lZero++;
            } else {
                break;
            }
        }
        int count =1;

        count += (rZero*(rZero+1))/2 +  (lZero*(lZero+1))/2;

        System.out.println(j + "  " + rZero);
        System.out.println(i + "  " + lZero);

        return count;

    }
}
