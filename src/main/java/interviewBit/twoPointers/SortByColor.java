package interviewBit.twoPointers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SortByColor {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().trim().split("\\s+");
        ArrayList<Integer> list = new ArrayList<>();
        for (String s:line) {
            list.add(Integer.parseInt(s));
        }
        new SortByColor().sortColors(list);
        System.out.println(list);
    }
    public void sortColors(ArrayList<Integer> a) {
        int n = a.size();
        int i = 0;
        int k = n-1;
        for(int j=0;j<=k;j++) {
            int x = a.get(j);
            if(x==0) {
                a.set(i, x);
                i++;
            } else if(x==2) {
                int tmp = a.get(k);
                a.set(k,x);
                a.set(j,tmp);
                j--;
                k--;
            }
        }
        for(int c = i;c<=k;c++) {
            a.set(c, 1);
        }
    }
}

