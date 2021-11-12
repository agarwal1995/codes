package personal.arrays;

import java.util.ArrayList;

public class MoveZeroes {

    public ArrayList<Integer> solve(ArrayList<Integer> list) {
        int i = 0;
        int n = list.size();
        int j=0;

        while (i<n && j<n) {
            if(list.get(i) == 0 && list.get(j)!=0) {
                swap(list, i, j);
                i++;
                j++;
            } else if(list.get(i)!=0) {
                i++;
                j++;
            } else if(list.get(i)==0 && list.get(j)==0){
                j++;
            }
        }
        return list;
    }

    private void swap(ArrayList<Integer> list, int i, int j) {
        int t = list.get(i);
        list.set(i, list.get(j));
        list.set(j, t);

    }
}
