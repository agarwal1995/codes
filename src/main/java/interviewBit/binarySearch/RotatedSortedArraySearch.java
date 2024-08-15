package interviewBit.binarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author raag
 */
public class RotatedSortedArraySearch {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().trim().split("\\s+");
        List<Integer> list =
                Arrays.stream(line).map(Integer::parseInt).collect(Collectors.toList());
        System.out.println(new RotatedSortedArraySearch().searchPivotPoint(list, 0, list.size()-1));
    }

    public int search(final List<Integer> list, int B) {
        int x = searchPivotPoint(list, 0, list.size()-1);
        if (x==-1) {
            return binarySearch(list, 0, list.size()-1, B);
        } else {
            return Math.max(binarySearch(list, 0, x-1,B), binarySearch(list, x, list.size()-1, B));
        }
    }

    private int binarySearch(List<Integer> list, int l, int r, int B) {
        while (l<=r) {
            int mid = l + (r-l)/2;
            if (list.get(mid)==B) {
                return mid;
            }
            if (list.get(mid)>B) {
                r = mid-1;
            } else  {
                l = mid+1;
            }
        }
        return -1;
    }

    private int searchPivotPoint(List<Integer> list, int l, int r) {

        int n = list.size();

        int mid = l + (r-l)/2;
        if(l>r) {
            return -1;
        }
        if (mid == 0 || mid == n - 1) {
            return -1;
        }
        if (list.get(mid - 1) > list.get(mid) && list.get(mid) < list.get(mid + 1)) {
            return mid;
        }
        return Math.max(searchPivotPoint(list, l, mid-1), searchPivotPoint(list, mid+1, r));
    }
}
