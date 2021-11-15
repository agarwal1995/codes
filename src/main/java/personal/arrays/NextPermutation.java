package personal.arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class NextPermutation {

    public ArrayList<Integer> nextPermutation(ArrayList<Integer> list) {
        int n = list.size();
        int index = -1;
        int toIndex = -1;
        for (int i = n-2;i>=0;i--) {
            if(list.get(i) < list.get(i+1)) {
                index = i;
                break;
            }
        }
        if(index==-1) {
            Collections.sort(list);
            return list;
        }
        for (int i=index+1;i<n;i++) {
            if(list.get(i) > list.get(index)) {
                toIndex = i;
            }
        }
        int t = list.get(index);
        list.set(index, list.get(toIndex));
        list.set(toIndex, t);
        Collections.sort(list.subList(index+1, list.size()));
        return list;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().trim().split("\\s+");
        ArrayList<Integer> list = new ArrayList<>();
        for (String s : line) {
            list.add(Integer.parseInt(s));
        }
        System.out.println(new NextPermutation().nextPermutation(list));
    }
}
