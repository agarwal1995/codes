package interviewBit.math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DIvisibleBy60 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().trim().split("\\s+");
        ArrayList<Integer> list = new ArrayList<>();
        for(String s:line) {
            list.add(Integer.parseInt(s));
        }
        System.out.println(new DIvisibleBy60().divisibleBy60(list));
    }
    public int divisibleBy60(ArrayList<Integer> A) {
        int sumOfDigits = 0;
        boolean isZero = false;
        boolean isEven = false;
        int countZero = 0;
        for(int x:A) {
            sumOfDigits+=x;
            //  System.out.println(x);
            if(!isZero)
                isZero = x == 0;
            countZero = countZero + (x==0?1:0);
            if(!isEven)
                isEven = x > 0 && x % 2 == 0;
        }
        if(sumOfDigits==0) {
            return 1;
        }
        return (isZero && (sumOfDigits%3==0) && (isEven || countZero>1) )?1:0;
    }
}
