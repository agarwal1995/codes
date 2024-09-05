package interviewBit.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * N children are standing in a line. Each child is assigned a rating value.
 * You are giving candies to these children subjected to the following requirements:
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * What is the minimum number of candies you must give?
 * @author raag
 */
public class DistributeCandy {

    public static void main(String[] args) {
        DistributeCandy dc = new DistributeCandy();
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,5,2,1));
        System.out.println(dc.candy(list));

        list = new ArrayList<>(Arrays.asList(1,2,3,5));
        System.out.println(dc.candy(list));
    }

    public int candy(ArrayList<Integer> A) {
        List<Integer> leftMax = new ArrayList<>();
        List<Integer> rightMax = new ArrayList<>();

        leftMax.add(0);
        for (int i=1;i<A.size();i++) {
            if (A.get(i)>A.get(i-1)) {
                leftMax.add(leftMax.get(i-1)+1);
            } else {
                leftMax.add(0);
            }
        }

        rightMax.add(0);
        for (int i=A.size()-2;i>=0;i--) {
            if (A.get(i)>A.get(i+1)) {
                rightMax.add(rightMax.get(A.size()-i-2)+1);
            } else {
                rightMax.add(0);
            }
        }

        Collections.reverse(rightMax);


        int sumCandy = 0;
        for (int i=0;i<A.size();i++) {
            sumCandy += Math.max(leftMax.get(i), rightMax.get(i)) + 1;
        }

        return sumCandy;
    }
}
