package interviewBit.twoPointers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class PairWithGivenDifference {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().trim().split("\\s+");
        ArrayList<Integer> list = new ArrayList<>();
        for (String s:line) {
            list.add(Integer.parseInt(s));
        }
        System.out.println(new PairWithGivenDifference().solve(list, 369));;
    }

    public int solve(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        System.out.println(A);
        int i=0,j=A.size()-1;

        for (int k=0;k<A.size();k++) {
            for(int l=0;l<A.size();l++) {
                if(k!=l && (A.get(k)-A.get(l) )==B) {
                    System.out.println(A.get(k) + "   " + A.get(l));
                }
            }
        }

        while(i<j) {
            int x = A.get(j)-A.get(i);
            System.out.println(x + "  " + i + "  " + j);
            if((A.get(j)-A.get(i)) == B) {
                return 1;
            }
            if((A.get(j)-A.get(i)) >B) {
                j--;
            }else
            if((A.get(j)-A.get(i)) <B) {
                i++;
            }
        }
        return 0;
    }

    //42 -533 -666 -500 169 724 478 358 -38 -536 705 -855 281 -173 961 -509 -5 942 -173 436 -609 -396 902 -847 -708 -618 421 -284 718 895 447 726 -229 538 869 912 667 -701 35 894 -297 811 322
}
