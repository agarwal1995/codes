package interviewBit.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author raag
 */
public class MaxContinuousSeriesOf1 {

    public static void main(String[] args) {
        System.out.println(new MaxContinuousSeriesOf1().maxone(new ArrayList<>(Arrays.asList(1, 0, 0, 0, 1, 0, 1)), 2));
        System.out.println(new MaxContinuousSeriesOf1().maxone(new ArrayList<>(Arrays.asList(1, 1, 0, 1, 1, 0, 0, 1, 1, 1)), 1));
    }

    public ArrayList<Integer> maxone(ArrayList<Integer> A, int B) {
        int startIndex = -1;
        int max = 0;

        int i=0;
        int j=0;
        int n = A.size();
        int l = 0;
        while (i<n && j<n) {
            if (i>j) {
                j++;
                continue;
            }
            if (A.get(j).compareTo(1) == 0) {
                j++;
            } else if (l<B) {
                j++;
                l++;
            } else {
                if (A.get(i).compareTo(0)==0) {
                    if (l>0)
                    l--;
                }
                i++;
            }
            int size = j-i;
            if (size>max) {
                max = size;
                startIndex = i;
            }
        }
        if (startIndex==-1) {
            return new ArrayList<>();
        }
//        return IntStream
//                .rangeClosed(startIndex, startIndex + max-1)
//                .boxed()
//                .collect(Collectors.toCollection(ArrayList::new));
//        return Stream.iterate(startIndex, k-> k + 1)
//                .limit(max)
//                .collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Integer> res = new ArrayList<>();
        for (int k=startIndex;k<startIndex+max;k++) {
            res.add(k);
        }
        return res;
    }
}
