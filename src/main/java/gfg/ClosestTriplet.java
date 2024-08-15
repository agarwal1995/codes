package gfg;

/**
 * @author raag
 */
//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int P, Q, R, i;
            P = Integer.parseInt(read.readLine());
            int A[] = new int[P];
            String s1[] = read.readLine().split(" ");
            for (i = 0; i < P; i++) A[i] = Integer.parseInt(s1[i]);
            Q = Integer.parseInt(read.readLine());
            int B[] = new int[Q];
            String s2[] = read.readLine().split(" ");
            for (i = 0; i < Q; i++) B[i] = Integer.parseInt(s2[i]);
            R = Integer.parseInt(read.readLine());
            int C[] = new int[R];
            String s3[] = read.readLine().split(" ");
            for (i = 0; i < R; i++) C[i] = Integer.parseInt(s3[i]);
            Solution ob = new Solution();
            System.out.println(ob.findClosest(P, Q, R, A, B, C));
        }
    }
}
// } Driver Code Ends

// User function Template for Java


class Solution {
    int findClosest(int P, int Q, int R, int A[], int B[], int C[]) {

        int i=0, j=0, k=0;
        int min = Integer.MAX_VALUE;

        while(i<P && j<Q && k<R) {
            int max = Math.max(Math.max(Math.abs(A[i]-B[j]), Math.abs(C[k]-B[j])) , Math.abs(A[i]-C[k]));


            min = Math.min(max,min);

            // System.out.println(i + "  " + j + "  " + k);
            // System.out.println(max);

            if(i==P-1 && j==Q-1 && k==R-1) {

                break;
            }

            if(i==P-1 && j==Q-1) {
                k++;
                continue;
            } else if(i==P-1 && k==R-1) {
                j++;
                continue;
            } else if(j==Q-1 && k==R-1) {
                i++;
                continue;
            }

            int excludeIndex = -1;
            if(i==P-1) {
                excludeIndex = 0;
            } else if(j==Q-1) {
                excludeIndex = 1;
            } else if(k==R-1) {
                excludeIndex = 2;
            }

            int[] array = new int[3];
            array[0] = A[i];
            array[1] = B[j];
            array[2] = C[k];

            // System.out.println(Arrays.toString(array));
            int minIndex = findMinimumIndex(array, excludeIndex);

            if(minIndex==0) {
                i++;
            } else if(minIndex==1) {
                j++;
            } else {
                k++;
            }

        }

        return min;
    }


    private int findMinimumIndex(int[] array, int excludeIndex) {
        int minIndex = 0;
        for(int i=0;i<3;i++) {
            if(i!=excludeIndex) {
                minIndex = array[i] < array[minIndex] ? i : minIndex;
            }
        }
        return minIndex;
    }

    public int abs(int a) {
        return (a <= 0) ? 0 - a : a;
    }
};