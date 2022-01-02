package personal.twopointers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SortByColor {

    public void sortColors(ArrayList<Integer> a) {
        int i=0, j=a.size()-1, k=0;

        while (i<=j) {
            if(a.get(i).equals(0)) {
                swap(a, i, k);
                k++;
                i++;
            } else if(a.get(i).equals(1)) {
                i++;
            } else if(a.get(i).equals(2)) {
                while (i<=j) {
                    if(!a.get(j).equals(2)) {
                        swap(a, i, j);
                        j--;
                        break;
                    } else {
                        j--;
                    }
                }
            }
        }
        System.out.println(a);
    }

    private void swap(ArrayList<Integer> a, int i, int j) {
        int c = a.get(i);
        a.set(i, a.get(j));
        a.set(j, c);
    }

    public static void main(String[] args) throws Exception {
        ArrayList<Integer> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().trim().split("\\s+");
        for (String s:line) {
            list.add(Integer.parseInt(s));
        }
        new SortByColor().sortColors(list);
    }
}
