package interviewBit.arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Given an integer array A of size N.
 * You have to pick exactly B elements from either left or right end of the array A to get the maximum sum.
 * Find and return this maximum possible sum.
 */
public class PickFromBothSides {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().trim().split("\\s+");
        ArrayList<Integer> list = new ArrayList<>();
        for(String s : line) {
            list.add(Integer.parseInt(s));
        }
        PickFromBothSides pickFromBothSides = new PickFromBothSides();
        System.out.println(pickFromBothSides.solve(list, 81));
    }

    /**
     *
     * First iterate B elements and find sum of those
     * then iterate from end, and while iterating add the last
     * element and subtract the kth (start from B to 0) element
     *
     * @param A integer array list
     * @param B number of elements to be picked
     * @return maximum sum
     */
    public int solve(ArrayList<Integer> A, int B) {
        int sum = 0;
        for(int i=B-1;i>=0;i--) {
            sum += A.get(i);
        }
        int n = A.size();
        int max = sum;
        int k = B;
        for(int j = n-1; j>=(n-B); j--) {
            sum += A.get(j) - A.get(--k);
            max = Math.max(sum, max);
        }
        return max;
    }
}
