package interviewBit.arrays;

import java.util.ArrayList;
import java.util.Collections;

public class AddOneToNumber {
    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        int n= A.size()-1;
        int carry = 1;
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=n;i>=0;i--) {
            int x = A.get(i) + carry;
            result.add(x%10);
            carry = x/10;
        }
        if(carry!=0){
            result.add(carry);
        }
        n = result.size()-1;
        for (int i=n;i>0;i--) {
            if(result.get(i)==0) {
                result.remove(i);
            } else {
                break;
            }
        }
        // Collection return type is null
        Collections.reverse(result);
        return result;
    }
}
