package personal.arrays;

import java.util.ArrayList;

public class SegregateZeroesAndOnes {

    public ArrayList<Integer> solve(ArrayList<Integer> list) {
        int n = list.size();
        int i = 0;
        int j = n-1;
        boolean findAMismatch0 = false;
        boolean findAMismatch1 = false;
        while (i<j) {
            if(list.get(i) == 1) {
                findAMismatch1 = true;
            }
            if(list.get(j) == 0) {
                findAMismatch0 = true;
            }

            if(findAMismatch0 && findAMismatch1) {
                swap(list, i, j);
                findAMismatch0 = findAMismatch1 = false;
                i++;
                j--;
            } else if(findAMismatch0) {
                i++;
            } else if(findAMismatch1) {
                j++;
            } else {
                i++;
                j--;
            }
        }
        return list;
    }

    private void swap(ArrayList<Integer> list, int i, int j) {
        int t = list.get(i);
        list.set(i, list.get(j));
        list.set(j, t);

    }

    public static void main(String[] args) {
        ArrayList<Integer> sol = new ArrayList<>(5);
        sol.set(2,3);
    }
}
