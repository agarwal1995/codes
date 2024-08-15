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
public class SortedInsertPosition {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().trim().split("\\s+");
        List<Integer> list =
                Arrays.stream(line).map(Integer::parseInt).collect(Collectors.toList());
        System.out.println(new SortedInsertPosition().searchInsert(new ArrayList<>(list), 77));
    }
    public int searchInsert(ArrayList<Integer> a, int b) {
        if(a.isEmpty()) {
            return 0;
        }
        if (a.get(a.size()-1)<b) {
            return a.size();
        }
        if (a.get(0)>b) {
            return 0;
        }
        return searchElement(a, b);



    }

    private int searchElement(ArrayList<Integer> list, int B) {
        int l = 0;
        int r = list.size()-1;
        while (l<=r) {
            int mid = (l+r)/2;
            if(list.get(mid).compareTo(B)==0) {
                return mid;
            }
            if ((mid+1<list.size() && mid>0 && list.get(mid)<B && list.get(mid+1)>B)) {
                return mid+1;
            }
            if ((mid+1<list.size() && mid>0 && list.get(mid-1)<B && list.get(mid)>B)) {
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
}
