package interviewBit.math;

import java.util.ArrayList;

public class PrimeSum {
    public ArrayList<Integer> primesum(int A) {
        int x = (int)Math.ceil(Math.sqrt(A));
        int sum = 0;
        boolean[] primeArray = new boolean[A+1];
        primeArray[0]=primeArray[1]=true;
        for(int i=2;i<=x;i++){
            if(!primeArray[i]) {
                for(int j=2;j*i<=A;j++) {
                    primeArray[j*i]=true;
                }
            }
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=2;i<=A/2;i++) {
            if(!primeArray[i] && !primeArray[A-i]){
                list.add(i);
                list.add(A-i);
                return list;
            }
        }
        //System.out.println(Arrays.toString(primeArray));
        return list;
    }
}
