package interviewBit.backtracking;

import java.util.Arrays;

/**
 * @author raag
 */
public class KthPermutation {

    public static void main(String[] args) {
        System.out.println(new KthPermutation().getPermutation(4, 7));
    }

    int c = 0;

    public String getPermutation(int A, int B) {
        Integer[] array = new Integer[A];
        for (int i=0;i<A;i++) {
            array[i] = i+1;
        }
//        rec(A, array, 0);
        rec(A, array, 0, B);
        return Arrays.toString(array).replaceAll("\\[|]|,|\\s", "");
    }

    private boolean rec(int n, Integer[] array, int start, int B) {
        if (start==n) {
            System.out.println(Arrays.toString(array));
            c++;
            if (c==B) {
                return true;
            }
            return false;
        }

        for (int i=start;i<n;i++) {
            swap(array, start, i);
            Arrays.sort(array, start+1, array.length);
            if (rec(n, array, start+1, B)) {
                return true;
            }
            Arrays.sort(array, start+1, array.length);
            swap(array, start, i);
        }
        return false;
    }

    private void swap(Integer[] array, int i, int j) {
        if (i==j) {
            return;
        }
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private void rec(int n, Integer[] array, int start) {
        if (start==n) {
            System.out.println(Arrays.toString(array));
            return;
        }

        for (int i=start;i<n;i++) {
            swap(array, start, i);
            Arrays.sort(array, start+1, array.length);
            rec(n, array, start+1);
            Arrays.sort(array, start+1, array.length);
            swap(array, start, i);
        }
    }
}
