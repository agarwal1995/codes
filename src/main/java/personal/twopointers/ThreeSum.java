package personal.twopointers;

import java.util.ArrayList;
import java.util.Comparator;

public class ThreeSum {

    public int threeSumClosest(ArrayList<Integer> A, int B) {
        A.sort(Comparator.naturalOrder());

        int closest = Integer.MAX_VALUE;
        int totalSum=0;
        int sumAtClosest=0;
        for(int a=0;a<A.size()-2;a++) {
            int sumToBe = B - A.get(a);

            int i=a+1;
            int j=A.size()-1;
            int sumTillNow = 0;
            while(i<j) {
                sumTillNow = A.get(i) + A.get(j);
                if(sumToBe==sumTillNow) {
                    return B;
                }
                if(sumTillNow>sumToBe) {
                    j--;
                } else {
                    i++;
                }
                totalSum = A.get(a) + sumTillNow;

                if(Math.abs(totalSum-B) < closest) {
                    closest = Math.abs(totalSum-B);
                    sumAtClosest = totalSum;
                }
            }
        }
        return sumAtClosest;
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        ArrayList<Integer> list = new ArrayList<>();
        // 2, 1, -9, -7, -8, 2, -8, 2, 3, -8
        list.add(2);
        list.add(1);
        list.add(-9);
        list.add(-7);
        list.add(-8);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(-8);
        System.out.println(threeSum.threeSumClosest(list, -1));
    }
}
