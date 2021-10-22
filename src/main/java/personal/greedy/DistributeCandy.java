package personal.greedy;

import java.util.ArrayList;
import java.util.Arrays;

public class DistributeCandy {

    public int candy(ArrayList<Integer> A) {
        int n = A.size();
        int[] left = new int[A.size()];
        int[] right = new int[A.size()];

        left[0]=right[n-1]=1;

        for(int i=1;i<n;i++) {
            left[i] = A.get(i) > A.get(i-1) ? left[i-1]+1 : 1;
        }

        for(int i=n-2;i>=0;i--) {
            right[i] = A.get(i) > A.get(i+1) ? right[i+1] +1 : 1;
        }

        int candy = 0;
        for (int i=0;i<n;i++) {
            candy = candy + Math.max(left[i], right[i]);
        }
        return candy;
    }
    public static void main(String[] args) {
        int[] array = new int[] {1,5,2,1};
        DistributeCandy distributeCandy = new DistributeCandy();
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(5);
        list.add(2);
        list.add(1);
        System.out.println(distributeCandy.candy(list));
    }
}
