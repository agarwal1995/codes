package interviewBit.twoPointers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().trim().split("\\s+");
        ArrayList<Integer> list = new ArrayList<>();
        for (String s:line) {
            list.add(Integer.parseInt(s));
        }
        System.out.println(new RemoveDuplicatesFromSortedArray().removeDuplicates(list));;
    }

    public int removeDuplicates(ArrayList<Integer> a) {
        int count = 1;
        int res = 0;
        int prev = a.get(0);
        int j=0;
        for(int i=1;i<a.size();i++) {
            if(a.get(i)!=prev) {
                a.set(j, prev);
                j++;
            }
            prev = a.get(i);
        }
        if(count==1) {
            a.set(j, prev);
        }
        return ++j;
    }
}
