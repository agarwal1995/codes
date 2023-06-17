package interviewBit.bitManipulation;

import java.util.List;

/**
 * Given an array of integers A, every element appears twice except for one. Find that single one in linear runtime complexity without using extra space
 * @author raag
 */
public class SingleNumber {

    public static void main(String[] args) {

    }

    /**
     * xor all the element, the result will contain the req element as xor of same number is 0
     */
    public int singleNumber(final List<Integer> A) {
        int sum = 0;
        for(int x:A) {
            sum = sum^x;
        }
        return sum;
    }
}
