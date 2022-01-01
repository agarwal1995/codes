package personal.twopointers;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOf2SortedArrays {

    public ArrayList<Integer> intersect(final List<Integer> A, final List<Integer> B) {
        int i=0, j=0;

        int m = A.size();
        int n = B.size();

        ArrayList<Integer> sol = new ArrayList<>();
        while (i<m && j<n) {
            if(A.get(i).equals(B.get(j))) {
                sol.add(A.get(i));
                i++;j++;
            } else if(A.get(i) > B.get(i)) {
                j++;
            } else {
                i++;
            }
        }
        return sol;
    }

    public static void main(String[] args) {

    }
}
