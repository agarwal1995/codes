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
public class SearchInBitonicArray {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().trim().split("\\s+");
        List<Integer> list =
        Arrays.stream(line).map(Integer::parseInt).collect(Collectors.toList());
//        System.out.println(new SearchInBitonicArray().searchBitonicPoint(new ArrayList<>(list)));
        System.out.println(new SearchInBitonicArray().solve(new ArrayList<>(list), 12));
    }

    public int solve(ArrayList<Integer> A, int B) {
        int bitonicIndex = searchBitonicPoint(A);
        int leftSide = searchElementLeft(A, 0, bitonicIndex, B);
        int rightSide = searchElementRight(A, bitonicIndex+1, A.size()-1, B);
        return Math.max(leftSide, rightSide);
    }
    private int searchBitonicPoint(ArrayList<Integer> list) {

        int l = 0;
        int r = list.size()-1;

        int n = list.size();

        while (l<=r) {
            int mid = (r + l) / 2;
            if (mid == 0 || mid == n - 1) {
                return mid;
            }
            if (list.get(mid - 1) < list.get(mid) && list.get(mid) > list.get(mid + 1)) {
                return mid;
            }
            if (list.get(mid) < list.get(mid + 1)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    private int searchElementLeft(ArrayList<Integer> list, int l, int r, int B) {
        while (l<=r) {
            int mid = (l+r)/2;
            if(list.get(mid).compareTo(B)==0) {
                return mid;
            }
            if (list.get(mid)>B) {
                r = mid-1;
            } else {
                l = mid+1;
            }
        }
        return -1;
    }

    private int searchElementRight(ArrayList<Integer> list, int l, int r, int B) {
        while (l<=r) {
            int mid = (l+r)/2;
            if(list.get(mid).compareTo(B)==0) {
                return mid;
            }
            if (list.get(mid)<B) {
                r = mid-1;
            } else {
                l = mid+1;
            }
        }
        return -1;
    }
}
