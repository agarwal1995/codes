package interviewBit.twoPointers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MaximumOnesAfterModification {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().trim().split("\\s+");
        ArrayList<Integer> list = new ArrayList<>();
        for (String s:line) {
            list.add(Integer.parseInt(s));
        }
        System.out.println(new MaximumOnesAfterModification().solve(list, 2));
        System.out.println(list);
    }

    public int solve(ArrayList<Integer> A, int B) {
        int i=0;
        int k=0;
        int j=0;
        int n = A.size();
        int maxC = 0;
        int maxTillNow = 0;
        int z = B;
        for(;i<n && k<n;i++) {
            if(A.get(i)==1) {
                maxC = Math.max(maxC, i-k+1);
            } else {
                if(B>0) {
                    B--;
                    maxC = Math.max(maxC, i-k+1);
                } else {
                    while(j<=i) {
                        if(A.get(j)==0) {
                            k = j+1;
                            i--;
                            j=j+1;
                            B++;
                            break;
                        }
                        j++;
                    }
                }
            }
        }
        return maxC;
    }
}
