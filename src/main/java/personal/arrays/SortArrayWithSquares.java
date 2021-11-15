package personal.arrays;

import java.util.ArrayList;

public class SortArrayWithSquares {

    public ArrayList<Integer> solve(ArrayList<Integer> list) {
        int i = findLastNegativeNumber(list);
        int j = i+1;
        ArrayList<Integer> sol = new ArrayList<>();
        int n = list.size();
        int k = n;
        while (k>0) {
            if(i>=0 && j<n) {
                if(Math.abs(list.get(i)) < list.get(j)) {
                    sol.add((int) Math.pow(list.get(i), 2));
                    i--;
                } else {
                    sol.add((int) Math.pow(list.get(j), 2));
                    j++;
                }
                continue;
            }
            if(i>=0) {
                sol.add((int) Math.pow(list.get(i), 2));
                i--;
            }
            if(j<n) {
                sol.add((int) Math.pow(list.get(j), 2));
                j++;
            }
            k--;
        }
        return sol;
    }

    private int findLastNegativeNumber(ArrayList<Integer> list) {
        int index = -1;
        for(int i=0;i<list.size();i++) {
            if(list.get(i) > 0) {
                break;
            }
            index = i;
        }
        return index;
    }

    public static void main(String[] args) {

    }
}
