package interviewBit.math;

import java.util.ArrayList;

public class FizzBuzz {
    public ArrayList<String> fizzBuzz(int A) {
        ArrayList<String> result = new ArrayList<>();
        for(int i=1;i<=A;i++) {
            StringBuilder sbr = new StringBuilder();
            if(i%3==0) {
                sbr.append("Fizz");
            }
            if(i%5==0) {
                sbr.append("Buzz");
            }
            if(sbr.length()==0) {
                sbr.append(i);
            }
            result.add(sbr.toString());
        }
        return result;
    }
}
