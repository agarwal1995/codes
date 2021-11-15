package personal.arrays;

import java.util.ArrayList;
import java.util.Collections;

public class ArraySum {

    public ArrayList<Integer> addArrays(ArrayList<Integer> A, ArrayList<Integer> B) {

        ArrayList<Integer> sol = new ArrayList<>();
        int i = A.size()-1;
        int j = B.size()-1;

        int carry = 0;
        while (i>=0 && j>=0) {
            int sum = A.get(i) + A.get(j) + carry;
            if(sum>9) {
                carry = 1;
                sum = sum%10;
            } else{
                carry=0;
            }
            sol.add(sum);
            i--;
            j--;
        }
        if(i>=0) {
            while (i>=0) {
                int sum = A.get(i) + carry;
                if(sum>9) {
                    carry = 1;
                    sum = sum%10;
                }else{
                    carry=0;
                }
                sol.add(sum);
                i--;
            }
        } else if(j>=0) {
            while (j>=0) {
                int sum = A.get(j) + carry;
                if(sum>9) {
                    carry = 1;
                    sum = sum%10;
                }else{
                    carry=0;
                }
                sol.add(sum);
                j--;
            }
        }

        if(carry==1){
            sol.add(carry);
        }
        Collections.reverse(sol);
        return sol;
    }
}
