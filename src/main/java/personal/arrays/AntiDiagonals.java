package personal.arrays;

import java.util.ArrayList;

public class AntiDiagonals {

    public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> list) {
        ArrayList<ArrayList<Integer>> sol = new ArrayList<>();

        int n = list.size();
        for (int j=0;j<n;j++) {
            int i=0,k=j;
            ArrayList<Integer> list1 = new ArrayList<>();
            while (k>=0 && i<n) {
                list1.add(list.get(i).get(k));
                i++;
                k--;
            }
            sol.add(list1);
        }

        for (int i=1;i<n;i++) {
            int j = n-1, k=i;
            ArrayList<Integer> list1 = new ArrayList<>();
            while (j>=0 && k<n) {
                list1.add(list.get(k).get(j));
                k++;
                j--;
            }
            sol.add(list1);
        }

        return sol;
    }

    public static void main(String[] args) {

    }
}
