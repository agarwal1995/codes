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
public class SearchForARange {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().trim().split("\\s+");
        List<Integer> list =
                Arrays.stream(line).map(Integer::parseInt).collect(Collectors.toList());
        System.out.println(new SearchForARange().searchRange(new ArrayList<>(list), 10));
    }

    public ArrayList<Integer> searchRange(final List<Integer> A, int B) {
        ArrayList<Integer> res = new ArrayList<>();
        int left = searchFirstPos(A, B);
        res.add(left);
        if (left==-1) {
            res.add(-1);
        } else {
            int right = searchLastPos(A, B);
            res.add(right);
        }
        return res;
    }

    private int searchFirstPos(List<Integer> list, int B) {
        int l = 0;
        int r = list.size()-1;
        int index = -1;
        while (l<=r) {
            int mid = (l+r)/2;
            if(list.get(mid).compareTo(B)==0) {
                index=mid;
                r = mid-1;
            }
            else if (list.get(mid)>B) {
                r = mid-1;
            } else {
                l = mid+1;
            }
        }
        return index;
    }

    private int searchLastPos(List<Integer> list, int B) {
        int l = 0;
        int r = list.size()-1;
        int index = -1;
        while (l<=r) {
            int mid = (l+r)/2;
            if(list.get(mid).compareTo(B)==0) {
                index=mid;
                l = mid+1;
            }
            else if (list.get(mid)>B) {
                r = mid-1;
            } else {
                l = mid+1;
            }
        }
        return index;
    }


}
