package personal.arrays;

import java.util.ArrayList;

public class MakeEqualArrayElements {

    public int solve(ArrayList<Integer> list, int x) {

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int a:list) {
            max = Math.max(max, a);
            min = Math.min(min, a);
        }

        if(max == min) {
            return 1;
        }

        if(!(max-x == min || min+x==max || max -x == min+x)) {
            return 0;
        }

        int val1 = min;
        int val2 = max;
        int val3 = min+x;

        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        for (int a : list) {
            if (a == val1 || a+x==val1 || a-x==val1) {
                count1++;
            }
            if (a == val2 || a+x==val2 || a-x==val2) {
                count2++;
            }
            if (a == val3 || a+x==val3 || a-x==val3) {
                count3++;
            }
        }

        int n = list.size();
        if(count1==n || count2 ==n ||  count3==n){
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {

    }
}
