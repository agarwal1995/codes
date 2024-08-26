package interviewBit.arrays;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Given a non-negative number represented as an array of digits,
 * add 1 to the number ( increment the number represented by the digits ).
 * The digits are stored such that the most significant digit is at the head of the list.
 *
 * @author raag
 */
public class AddOneToNumber {
    /**
     * Iterate the list from the end maintain carry 'i.e' sum/10,
     * add the number to carry and store the result in a new list
     * later iterate once more to check and remove any leading zeroes
     * @param A list of input integers
     * @return list of output with +1
     */
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
