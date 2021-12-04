package personal.search;

import java.util.ArrayList;

public class SearchInBitonicArray {

    int findMaximum(ArrayList<Integer> arr, int n) {
        int start = 0, end = n-1;
        while (start<=end) {
            int mid = (start + end )/2;
            if(mid>0 && mid<n-1 && arr.get(mid) > arr.get(mid+1) && arr.get(mid) > arr.get(mid-1)) {
                return mid;
            }
            if (mid <n-1 && arr.get(mid) > arr.get(mid+1)) {
                end = mid-1;
            } else if (mid == n-1) {
                return mid;
            } else if (mid < n-1 && arr.get(mid) < arr.get(mid+1)) {
                start = mid+1;
            }
        }
        return n-1;
    }

    public int solve(ArrayList<Integer> A, int B) {
        int midPoint = findMaximum(A, A.size());
        int left = binarySearchAsc(A,B,0, midPoint);
        if (left!=-1) {
            return left;
        }
        int right = binarySearchDesc(A,B,midPoint+1, A.size()-1);
        return right;
    }

    private int binarySearchAsc(ArrayList<Integer> arr, int b, int i, int j) {
        int start = i, end = j;
        while (start<=end) {
            int mid = (start+end)/2;
            if(arr.get(mid) == b) {
                return mid;
            }
            if(arr.get(mid) > b) {
                end = mid-1;
            } else if(arr.get(mid) < b) {
                start = mid +1;
            }
        }
        return -1;
    }

    private int binarySearchDesc(ArrayList<Integer> arr, int b, int i, int j) {
        int start = i, end = j;
        while (start<=end) {
            int mid = (start+end)/2;
            if(arr.get(mid) == b) {
                return mid;
            }
            if(arr.get(mid) > b) {
                start = mid +1;
            } else if(arr.get(mid) < b) {
                end = mid-1;
            }
        }
        return -1;
    }
}
