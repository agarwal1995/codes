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
public class SmallerOrEqualElements {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().trim().split("\\s+");
        List<Integer> list =
                Arrays.stream(line).map(Integer::parseInt).collect(Collectors.toList());
        System.out.println(new SmallerOrEqualElements().searchElement(new ArrayList<>(list), 0, list.size()-1, 4));
    }

//    public int solve(ArrayList<Integer> A, int B) {
//    }

    private int searchElement(ArrayList<Integer> list, int l, int r, int B) {
        while (l<=r) {
            int mid = (l+r)/2;
             if (list.get(mid)>B) {
                r = mid-1;
            } else {
                l = mid+1;
            }
        }
        return r+1;
    }
}
