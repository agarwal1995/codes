package personal.search;

import java.util.ArrayList;

public class FindPeakElement {

    public int solve(ArrayList<Integer> arr) {
        int n = arr.size();
        int start = 0, end = n-1;
        while (start<=end) {
            int mid = (start + end )/2;
            if(mid>0 && mid<n-1 && arr.get(mid) > arr.get(mid+1) && arr.get(mid) > arr.get(mid-1)) {
                return arr.get(mid);
            }
            if (mid <n-1 && arr.get(mid) > arr.get(mid+1)) {
                end = mid-1;
            } else if (mid == n-1) {
                return arr.get(mid);
            } else if (mid < n-1 && arr.get(mid) < arr.get(mid+1)) {
                start = mid+1;
            }
        }
        return arr.get(n-1);
    }
}
